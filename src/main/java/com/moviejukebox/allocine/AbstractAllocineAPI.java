/*
 *      Copyright (c) 2004-2013 YAMJ Members
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

import com.moviejukebox.allocine.tools.ApiUrl;
import com.moviejukebox.allocine.tools.WebBrowser;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Abstract implementation for Allocine API; common methods for XML and JSON.
 *
 * @author modmax
 */
public abstract class AbstractAllocineAPI implements AllocineAPIHelper {

    private static final String METHOD_SEARCH = "search";
    private static final String FILTER_MOVIE = "movie";
    private static final String FILTER_TVSERIES = "tvseries";
    private static final String METHOD_MOVIE = "movie";
    private static final String METHOD_TVSERIES = "tvseries";
    private static final String PARAM_PROFILE = "profile";
    private static final String PARAM_MEDIAFMT = "mediafmt";
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_STRIPTAGS = "striptags";
    private static final String PARAM_FORMAT = "format";
    private static final String PARAM_CODE = "code";
    private static final String METHOD_SEASON = "season";
    ApiUrl apiUrl;
    private final String format;
    @Deprecated
    private final String apiKey = "";

    /**
     * Create the API
     *
     * @param partnerKey The partner key for Allocine
     * @param secretKey The secret key for Allocine
     * @param format The format of the returned data
     */
    public AbstractAllocineAPI(String partnerKey, String secretKey, String format) {
        this.format = format;
        apiUrl = new ApiUrl(partnerKey, secretKey);
    }

    @Override
    public void setProxy(String host, String port, String username, String password) {
        WebBrowser.setProxyHost(host);
        WebBrowser.setProxyPort(port);
        WebBrowser.setProxyPassword(username, password);
    }

    protected void close(URLConnection connection, InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception ignore) {
                // ignore this error
            }
        }

        if (connection != null && (connection instanceof HttpURLConnection)) {
            try {
                ((HttpURLConnection) connection).disconnect();
            } catch (Exception ignore) {
                // ignore this error
            }
        }
    }

    protected URLConnection connectSearchMovieInfos_OLD(String query) throws IOException {
        String encode = URLEncoder.encode(query, "UTF-8");
        URL url = new URL("http://api.allocine.fr/rest/v3/search?partner=" + apiKey + "&format=" + format + "&filter=movie&q=" + encode);
        return WebBrowser.openProxiedConnection(url);
    }

    protected URLConnection connectSearchMovieInfos(String query) throws IOException {
        Map<String, String> params = new LinkedHashMap<String, String>();

        params.put("q", query);
        params.put(PARAM_FORMAT, format);
        params.put(PARAM_FILTER, FILTER_MOVIE);
//        if(count.length>0) {
//            params.put("count",String.valueOf(count[0]));
//        }

        URL url = apiUrl.generateUrl(METHOD_SEARCH, params);

        return WebBrowser.openProxiedConnection(url);
    }

    protected URLConnection connectSearchTvseriesInfos_OLD(String query) throws IOException {
        String encode = URLEncoder.encode(query, "UTF-8");
        URL url = new URL("http://api.allocine.fr/rest/v3/search?partner=" + apiKey + "&format=" + format + "&filter=tvseries&q=" + encode);
        return WebBrowser.openProxiedConnection(url);
    }

    protected URLConnection connectSearchTvseriesInfos(String query) throws IOException {
        Map<String, String> params = new LinkedHashMap<String, String>();

        params.put(PARAM_FORMAT, format);
        params.put(PARAM_FILTER, FILTER_TVSERIES);
        params.put("q", query);

        URL url = apiUrl.generateUrl(METHOD_SEARCH, params);
        return WebBrowser.openProxiedConnection(url);
    }

    protected URLConnection connectGetMovieInfos_OLD(String allocineId) throws IOException {
        // HTML tags are removed from synopsis & synopsisshort
        URL url = new URL("http://api.allocine.fr/rest/v3/movie?partner=" + apiKey + "&profile=large&mediafmt=mp4-lc&format=" + format + "&filter=movie&striptags=synopsis,synopsisshort&code=" + allocineId);
        return WebBrowser.openProxiedConnection(url);
    }

    protected URLConnection connectGetMovieInfos(String allocineId) throws IOException {
        Map<String, String> params = new LinkedHashMap<String, String>();

        params.put(PARAM_PROFILE, "large");
        params.put(PARAM_MEDIAFMT, "mp4-lc");
        params.put(PARAM_STRIPTAGS, "synopsis,synopsisshort");
        params.put(PARAM_FORMAT, format);
        params.put(PARAM_FILTER, FILTER_MOVIE);
        params.put(PARAM_CODE, allocineId);

        URL url = apiUrl.generateUrl(METHOD_MOVIE, params);
        return WebBrowser.openProxiedConnection(url);
    }

    protected URLConnection connectGetTvSeriesInfos_OLD(String allocineId) throws IOException {
        // HTML tags are removed from synopsis & synopsisshort
        URL url = new URL("http://api.allocine.fr/rest/v3/tvseries?partner=" + apiKey + "&profile=large&mediafmt=mp4-lc&format=" + format + "&filter=movie&striptags=synopsis,synopsisshort&code=" + allocineId);
        return WebBrowser.openProxiedConnection(url);
    }

    protected URLConnection connectGetTvSeriesInfos(String allocineId) throws IOException {
        Map<String, String> params = new LinkedHashMap<String, String>();

        params.put(PARAM_PROFILE, "large");
        params.put(PARAM_MEDIAFMT, "mp4-lc");
        params.put(PARAM_FILTER, FILTER_MOVIE);
        params.put(PARAM_STRIPTAGS, "synopsis,synopsisshort");
        params.put(PARAM_FORMAT, format);
        params.put(PARAM_CODE, allocineId);

        URL url = apiUrl.generateUrl(METHOD_TVSERIES, params);
        return WebBrowser.openProxiedConnection(url);
    }

    protected URLConnection connectGetTvSeasonInfos_OLD(Integer seasonCode) throws IOException {
        // HTML tags are removed from synopsis & synopsisshort
        URL url = new URL("http://api.allocine.fr/rest/v3/season?partner=" + apiKey + "&profile=large&mediafmt=mp4-lc&format=" + format + "&filter=movie&striptags=synopsis,synopsisshort&code=" + seasonCode);
        return WebBrowser.openProxiedConnection(url);
    }

    protected URLConnection connectGetTvSeasonInfos(Integer seasonCode) throws IOException {
        Map<String, String> params = new LinkedHashMap<String, String>();

        params.put(PARAM_PROFILE, "large");
        params.put(PARAM_MEDIAFMT, "mp4-lc");
        params.put(PARAM_FILTER, FILTER_MOVIE);
        params.put(PARAM_STRIPTAGS, "synopsis,synopsisshort");
        params.put(PARAM_FORMAT, format);
        params.put(PARAM_CODE, String.valueOf(seasonCode));

        URL url = apiUrl.generateUrl(METHOD_SEASON, params);
        return WebBrowser.openProxiedConnection(url);
    }
}
