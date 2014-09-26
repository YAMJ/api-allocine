/*
 *      Copyright (c) 2004-2014 YAMJ Members
 *      http://code.google.com/p/moviejukebox/people/list
 *
 *      This file is part of the Yet Another Movie Jukebox (YAMJ).
 *
 *      The YAMJ is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      any later version.
 *
 *      YAMJ is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with the YAMJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 *      Web: http://code.google.com/p/moviejukebox/
 *
 */
package com.moviejukebox.allocine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviejukebox.allocine.tools.ApiUrl;
import com.moviejukebox.allocine.tools.WebBrowser;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.http.CommonHttpClient;
import org.yamj.api.common.http.UserAgentSelector;

/**
 * Abstract implementation for Allocine API; common methods for XML and JSON.
 *
 * @author modmax
 */
public class AllocineApi {

    private static final Logger LOG = LoggerFactory.getLogger(AllocineApi.class);

    // Methods
    private static final String METHOD_SEARCH = "search";
    private static final String METHOD_MOVIE = "movie";
    private static final String METHOD_TVSERIES = "tvseries";
    private static final String METHOD_SEASON = "season";
    private static final String METHOD_EPISODE = "episode";
    private static final String METHOD_PERSON = "person";
    // Filters
    private static final String FILTER_MOVIE = "movie";
    private static final String FILTER_TVSERIES = "tvseries";
    private static final String FILTER_PERSON = "person";
    // Parameters
    private static final String PARAM_PROFILE = "profile";
    private static final String PARAM_MEDIAFMT = "mediafmt";
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_FORMAT = "format";
    private static final String PARAM_CODE = "code";
    private static final String PARAM_STRIPTAGS = "striptags";
    private static final String PARAM_FORMAT_VALUE = "json";
        
    private final ApiUrl apiUrl;
    private final CommonHttpClient httpClient;
    private ObjectMapper mapper;
    private Charset charset;
    
    /**
     * Create the API
     *
     * @param partnerKey The partner key for Allocine
     * @param secretKey The secret key for Allocine
     */
    public AllocineApi(String partnerKey, String secretKey) {
        this(partnerKey, secretKey, null);
    }

    /**
     * Create the API
     *
     * @param partnerKey The partner key for Allocine
     * @param secretKey The secret key for Allocine
     * @param format The format of the returned data
     * @param httpClient the http client to use instead internal web browser
     */
    public AllocineApi(String partnerKey, String secretKey, CommonHttpClient httpClient) {
        this.apiUrl = new ApiUrl(partnerKey, secretKey);
        this.httpClient = httpClient;
        this.mapper = new ObjectMapper();
        this.charset = Charset.forName("UTF-8");
    }

    public final void setProxy(Proxy proxy, String username, String password) {
        if (httpClient == null) {
            WebBrowser.setProxy(proxy);
            WebBrowser.setProxyPassword(username, password);
        }
    }

    public final void setProxy(String host, int port, String username, String password) {
        if (httpClient == null) {
            WebBrowser.setProxyHost(host);
            WebBrowser.setProxyPort(port);
            WebBrowser.setProxyPassword(username, password);
        }
    }

    private <T> T readJsonObject(URL url, Class<T> object) throws Exception {
        if (httpClient == null) {
            URLConnection connection = null;
            InputStream inputStream = null;
            try {
                connection = WebBrowser.openProxiedConnection(url);
                inputStream = connection.getInputStream();
                return mapper.readValue(inputStream, object);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception ignore) {}
                }

                if (connection != null && (connection instanceof HttpURLConnection)) {
                    try {
                        ((HttpURLConnection) connection).disconnect();
                    } catch (Exception ignore) {}
                }
            }
        } else {
            HttpGet httpGet = new HttpGet(url.toURI());
            httpGet.addHeader("accept", "application/json");
            httpGet.setHeader(HTTP.USER_AGENT, UserAgentSelector.randomUserAgent());
            return mapper.readValue(this.httpClient.requestContent(httpGet, charset), object);
        }
    }

    public Search searchMovies(String query) throws Exception {
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("q", query);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_FILTER, FILTER_MOVIE);
        params.put(PARAM_STRIPTAGS, "synopsis,synopsisshort");
        String url = apiUrl.generateUrl(METHOD_SEARCH, params);

        Search search;
        try {
            search = this.readJsonObject(new URL(url), Search.class);
        } catch (MalformedURLException error) {
            LOG.warn("Failed to convert '{}' to an URL, error: {}", url, error.getMessage());
            throw error;
        } catch (Exception error) {
            LOG.error("Failed search for tv series: " + query);
            throw error;
        }
        return search;
    }

    public Search searchTvSeries(String query) throws Exception {
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("q", query);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_FILTER, FILTER_TVSERIES);
        String url = apiUrl.generateUrl(METHOD_SEARCH, params);

        Search search;
        try {
            search = this.readJsonObject(new URL(url), Search.class);
        } catch (MalformedURLException error) {
            LOG.warn("Failed to convert '{}' to an URL, error: {}", url, error.getMessage());
            throw error;
        }
        
        return search;
    }

    public Search searchPersons(String query) throws Exception {
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("q", query);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_FILTER, FILTER_PERSON);
        String url = apiUrl.generateUrl(METHOD_SEARCH, params);

        Search search;
        try {
            search = this.readJsonObject(new URL(url), Search.class);
        } catch (MalformedURLException error) {
            LOG.warn("Failed to convert '{}' to an URL, error: {}", url, error.getMessage());
            throw error;
        }
        
        return search;
    }

    public MovieInfos getMovieInfos(String allocineId) throws Exception {
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put(PARAM_CODE, allocineId);
        params.put(PARAM_PROFILE, "large");
        params.put(PARAM_FILTER, FILTER_MOVIE);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        String url = apiUrl.generateUrl(METHOD_MOVIE, params);
        
        MovieInfos movieInfos;
        try {
            movieInfos = this.readJsonObject(new URL(url), MovieInfos.class);
        } catch (MalformedURLException error) {
            LOG.warn("Failed to convert '{}' to an URL, error: {}", url, error.getMessage());
            throw error;
        }
        
        return movieInfos;
    }

    public TvSeriesInfos getTvSeriesInfos(String allocineId) throws Exception {
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put(PARAM_PROFILE, "large");
        params.put(PARAM_MEDIAFMT, "mp4-lc");
        params.put(PARAM_FILTER, FILTER_MOVIE);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_CODE, allocineId);
        params.put(PARAM_STRIPTAGS, "synopsis,synopsisshort");
        String url = apiUrl.generateUrl(METHOD_TVSERIES, params);

        TvSeriesInfos tvSeriesInfo;
        try {
            tvSeriesInfo = this.readJsonObject(new URL(url), TvSeriesInfos.class);
        } catch (MalformedURLException error) {
            LOG.warn("Failed to convert '{}' to an URL, error: {}", url, error.getMessage());
            throw error;
        }

        return tvSeriesInfo;
    }

    public TvSeasonInfos getTvSeasonInfos(Integer seasonCode) throws Exception {
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put(PARAM_PROFILE, "large");
        params.put(PARAM_MEDIAFMT, "mp4-lc");
        params.put(PARAM_FILTER, FILTER_MOVIE);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_CODE, String.valueOf(seasonCode));
        params.put(PARAM_STRIPTAGS, "synopsis,synopsisshort");
        String url = apiUrl.generateUrl(METHOD_SEASON, params);
        
        TvSeasonInfos tvSeasonInfos; 
        try {
            tvSeasonInfos = this.readJsonObject(new URL(url), TvSeasonInfos.class);
        } catch (MalformedURLException error) {
            LOG.warn("Failed to convert '{}' to an URL, error: {}", url, error.getMessage());
            throw error;
        }

        return tvSeasonInfos;
    }

    public PersonInfos getPersonInfos(String allocineId) throws Exception {
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put(PARAM_PROFILE, "large");
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_CODE, allocineId);
        params.put(PARAM_STRIPTAGS, "biography,biographyshort");
        String url = apiUrl.generateUrl(METHOD_PERSON, params);

        PersonInfos personInfos;
        try {
            personInfos = this.readJsonObject(new URL(url), PersonInfos.class);
        } catch (MalformedURLException error) {
            LOG.warn("Failed to convert '{}' to an URL, error: {}", url, error.getMessage());
            throw error;
        }
        return personInfos;
    }

    public EpisodeInfos getEpisodeInfos(String allocineId) throws Exception {
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put(PARAM_PROFILE, "large");
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_CODE, allocineId);
        params.put(PARAM_STRIPTAGS, "synopsis,synopsisshort");
        String url = apiUrl.generateUrl(METHOD_EPISODE, params);

        EpisodeInfos episodeInfos;
        try {
            episodeInfos = this.readJsonObject(new URL(url), EpisodeInfos.class);
        } catch (MalformedURLException error) {
            LOG.warn("Failed to convert '{}' to an URL, error: {}", url, error.getMessage());
            throw error;
        }
        return episodeInfos;
    }
}
