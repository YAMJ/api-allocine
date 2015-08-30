/*
 *      Copyright (c) 2004-2015 YAMJ Members
 *      https://github.com/orgs/YAMJ/people
 *
 *      This file is part of the Allocine API.
 *
 *      The API is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      any later version.
 *
 *      The API is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with the API.  If not, see <http://www.gnu.org/licenses/>.
 *
 *      Web: https://github.com/YAMJ/api-allocine
 */
package com.moviejukebox.allocine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviejukebox.allocine.model.*;
import com.moviejukebox.allocine.tools.ApiUrl;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HTTP;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.exception.ApiExceptionType;
import org.yamj.api.common.http.*;

/**
 * Implementation for Allocine API
 *
 * @author modmax
 */
public class AllocineApi {

    // Constants
    private static final String ERROR_FAILED_TO_CONVERT_URL = "Failed to convert URL";
    private static final String LITERAL_LARGE = "large";
    private static final String LITERAL_SYNOPSIS = "synopsis,synopsisshort";
    private static final int HTTP_STATUS_300 = 300;
    private static final int HTTP_STATUS_500 = 500;
    // Methods
    private static final String METHOD_SEARCH = "search";
    private static final String METHOD_MOVIE = "movie";
    private static final String METHOD_TVSERIES = "tvseries";
    private static final String METHOD_SEASON = "season";
    private static final String METHOD_EPISODE = "episode";
    private static final String METHOD_PERSON = "person";
    private static final String METHOD_FILMOGRAPHY = "filmography";
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
    private final HttpClient httpClient;
    private final ObjectMapper mapper;
    private final Charset charset;
    private final IUserAgentSelector userAgentSelector;
    
    /**
     * Create the API
     *
     * @param partnerKey The partner key for Allocine
     * @param secretKey The secret key for Allocine
     * @param httpClient the HTTP client to use for requesting web pages
     * @throws com.moviejukebox.allocine.AllocineException
     */
    public AllocineApi(final String partnerKey, final String secretKey, final HttpClient httpClient) throws AllocineException {
        if (StringUtils.isBlank(partnerKey) || StringUtils.isBlank(secretKey)) {
            throw new AllocineException(ApiExceptionType.AUTH_FAILURE, "Must provide a Partner and Sercret key");
        }

        this.apiUrl = new ApiUrl(partnerKey, secretKey);
        this.httpClient = httpClient;
        this.mapper = new ObjectMapper();
        this.charset = Charset.forName("UTF-8");
        this.userAgentSelector = new AndroidBrowserUserAgentSelector();
    }

    /**
     * Get the information for a URL and process into an object
     *
     * @param <T>
     * @param url
     * @param object
     * @return
     * @throws AllocineException
     */
    private <T> T readJsonObject(final URL url, final Class<T> object) throws AllocineException {
        final String page = requestWebPage(url);
        if (StringUtils.isNotBlank(page)) {
            try {
                return mapper.readValue(page, object);
            } catch (IOException ex) {
                LoggerFactory.getLogger("test").info("{}", ex);
                throw new AllocineException(ApiExceptionType.MAPPING_FAILED, "Failed to read JSON object", url, ex);
            }
        }
        throw new AllocineException(ApiExceptionType.MAPPING_FAILED, "Failed to read JSON object", url);
    }

    /**
     * Search for a movie
     *
     * @param query
     * @return
     * @throws AllocineException
     */
    public Search searchMovies(final String query) throws AllocineException {
        final Map<String, String> params = new LinkedHashMap<>();
        params.put("q", query);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_FILTER, FILTER_MOVIE);
        params.put(PARAM_STRIPTAGS, LITERAL_SYNOPSIS);
        final String url = apiUrl.generateUrl(METHOD_SEARCH, params);

        try {
            return this.readJsonObject(new URL(url), Search.class);
        } catch (MalformedURLException ex) {
            throw new AllocineException(ApiExceptionType.INVALID_URL, ERROR_FAILED_TO_CONVERT_URL, url, ex);
        }
    }

    /**
     * Search for a TV Series
     *
     * @param query
     * @return
     * @throws AllocineException
     */
    public Search searchTvSeries(final String query) throws AllocineException {
        final Map<String, String> params = new LinkedHashMap<>();
        params.put("q", query);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_FILTER, FILTER_TVSERIES);
        params.put(PARAM_STRIPTAGS, LITERAL_SYNOPSIS);
        final String url = apiUrl.generateUrl(METHOD_SEARCH, params);

        try {
            return this.readJsonObject(new URL(url), Search.class);
        } catch (MalformedURLException ex) {
            throw new AllocineException(ApiExceptionType.INVALID_URL, ERROR_FAILED_TO_CONVERT_URL, url, ex);
        }
    }

    /**
     * Search for a person
     *
     * @param query
     * @return
     * @throws AllocineException
     */
    public Search searchPersons(final String query) throws AllocineException {
        final Map<String, String> params = new LinkedHashMap<>();
        params.put("q", query);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_FILTER, FILTER_PERSON);
        params.put(PARAM_STRIPTAGS, "biography,biographyshort");
        final String url = apiUrl.generateUrl(METHOD_SEARCH, params);

        try {
            return this.readJsonObject(new URL(url), Search.class);
        } catch (MalformedURLException ex) {
            throw new AllocineException(ApiExceptionType.INVALID_URL, ERROR_FAILED_TO_CONVERT_URL, url, ex);
        }
    }

    /**
     * Get Movie information
     *
     * @param allocineId
     * @return
     * @throws AllocineException
     */
    public MovieInfos getMovieInfos(String allocineId) throws AllocineException {
        final Map<String, String> params = new LinkedHashMap<>();
        params.put(PARAM_CODE, allocineId);
        params.put(PARAM_PROFILE, LITERAL_LARGE);
        params.put(PARAM_FILTER, FILTER_MOVIE);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_STRIPTAGS, LITERAL_SYNOPSIS);
        final String url = apiUrl.generateUrl(METHOD_MOVIE, params);

        try {
            return this.readJsonObject(new URL(url), MovieInfos.class);
        } catch (MalformedURLException ex) {
            throw new AllocineException(ApiExceptionType.INVALID_URL, ERROR_FAILED_TO_CONVERT_URL, url, ex);
        }
    }

    /**
     * Get TV Series information
     *
     * @param allocineId
     * @return
     * @throws AllocineException
     */
    public TvSeriesInfos getTvSeriesInfos(String allocineId) throws AllocineException {
        final Map<String, String> params = new LinkedHashMap<>();
        params.put(PARAM_PROFILE, LITERAL_LARGE);
        params.put(PARAM_MEDIAFMT, "mp4-lc");
        params.put(PARAM_FILTER, FILTER_MOVIE);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_CODE, allocineId);
        params.put(PARAM_STRIPTAGS, LITERAL_SYNOPSIS);
        final String url = apiUrl.generateUrl(METHOD_TVSERIES, params);

        try {
            return this.readJsonObject(new URL(url), TvSeriesInfos.class);
        } catch (MalformedURLException ex) {
            throw new AllocineException(ApiExceptionType.INVALID_URL, ERROR_FAILED_TO_CONVERT_URL, url, ex);
        }
    }

    /**
     * Get TV Season information
     *
     * @param seasonCode
     * @return
     * @throws AllocineException
     */
    public TvSeasonInfos getTvSeasonInfos(String allocineId) throws AllocineException {
        final Map<String, String> params = new LinkedHashMap<>();
        params.put(PARAM_PROFILE, LITERAL_LARGE);
        params.put(PARAM_MEDIAFMT, "mp4-lc");
        params.put(PARAM_FILTER, FILTER_MOVIE);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_CODE, allocineId);
        params.put(PARAM_STRIPTAGS, LITERAL_SYNOPSIS);
        final String url = apiUrl.generateUrl(METHOD_SEASON, params);

        try {
            return this.readJsonObject(new URL(url), TvSeasonInfos.class);
        } catch (MalformedURLException ex) {
            throw new AllocineException(ApiExceptionType.INVALID_URL, ERROR_FAILED_TO_CONVERT_URL, url, ex);
        }
    }

    /**
     * Get information on the person
     *
     * @param allocineId
     * @return
     * @throws AllocineException
     */
    public PersonInfos getPersonInfos(String allocineId) throws AllocineException {
        final Map<String, String> params = new LinkedHashMap<>();
        params.put(PARAM_PROFILE, LITERAL_LARGE);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_CODE, allocineId);
        params.put(PARAM_STRIPTAGS, "biography,biographyshort");
        final String url = apiUrl.generateUrl(METHOD_PERSON, params);

        try {
            return this.readJsonObject(new URL(url), PersonInfos.class);
        } catch (MalformedURLException ex) {
            throw new AllocineException(ApiExceptionType.INVALID_URL, ERROR_FAILED_TO_CONVERT_URL, url, ex);
        }
    }

    /**
     * Get filmography information
     *
     * @param allocineId
     * @return
     * @throws AllocineException
     */
    public FilmographyInfos getPersonFilmography(String allocineId) throws AllocineException {
        final Map<String, String> params = new LinkedHashMap<>();
        params.put(PARAM_PROFILE, LITERAL_LARGE);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_CODE, allocineId);
        params.put(PARAM_STRIPTAGS, LITERAL_SYNOPSIS);
        final String url = apiUrl.generateUrl(METHOD_FILMOGRAPHY, params);

        try {
            return this.readJsonObject(new URL(url), FilmographyInfos.class);
        } catch (MalformedURLException ex) {
            throw new AllocineException(ApiExceptionType.INVALID_URL, ERROR_FAILED_TO_CONVERT_URL, url, ex);
        }
    }

    /**
     * Get episode information
     *
     * @param allocineId
     * @return
     * @throws AllocineException
     */
    public EpisodeInfos getEpisodeInfos(String allocineId) throws AllocineException {
        final Map<String, String> params = new LinkedHashMap<>();
        params.put(PARAM_PROFILE, LITERAL_LARGE);
        params.put(PARAM_FORMAT, PARAM_FORMAT_VALUE);
        params.put(PARAM_CODE, allocineId);
        params.put(PARAM_STRIPTAGS, LITERAL_SYNOPSIS);
        final String url = apiUrl.generateUrl(METHOD_EPISODE, params);

        try {
            return this.readJsonObject(new URL(url), EpisodeInfos.class);
        } catch (MalformedURLException ex) {
            throw new AllocineException(ApiExceptionType.INVALID_URL, ERROR_FAILED_TO_CONVERT_URL, url, ex);
        }
    }

    /**
     * Download the URL into a String
     *
     * @param url
     * @return
     * @throws AllocineException
     */
    private String requestWebPage(URL url) throws AllocineException {
        try {
            final HttpGet httpGet = new HttpGet(url.toURI());
            httpGet.setHeader("accept", "application/json");
            httpGet.setHeader(HTTP.USER_AGENT, userAgentSelector.getUserAgent());

            final DigestedResponse response = DigestedResponseReader.requestContent(httpClient, httpGet, charset);

            if (response.getStatusCode() == 0) {
                throw new AllocineException(ApiExceptionType.CONNECTION_ERROR, response.getContent(), response.getStatusCode(), url);
            } else if (response.getStatusCode() >= HTTP_STATUS_500) {
                throw new AllocineException(ApiExceptionType.HTTP_503_ERROR, response.getContent(), response.getStatusCode(), url);
            } else if (response.getStatusCode() >= HTTP_STATUS_300) {
                throw new AllocineException(ApiExceptionType.HTTP_404_ERROR, response.getContent(), response.getStatusCode(), url);
            }

            return response.getContent();
        } catch (URISyntaxException ex) {
            throw new AllocineException(ApiExceptionType.INVALID_URL, "Invalid URL", url, ex);
        } catch (IOException ex) {
            throw new AllocineException(ApiExceptionType.CONNECTION_ERROR, "Error retrieving URL", url, ex);
        }
    }
}
