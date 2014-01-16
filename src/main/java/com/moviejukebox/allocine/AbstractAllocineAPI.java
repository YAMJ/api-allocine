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

import com.moviejukebox.allocine.tools.ApiUrl;
import com.moviejukebox.allocine.tools.WebBrowser;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Abstract implementation for Allocine API; common methods for XML and JSON.
 *
 * @author modmax
 */
public abstract class AbstractAllocineAPI implements AllocineAPIHelper {

    // Methods
    private static final String METHOD_SEARCH = "search";
    private static final String METHOD_MOVIE = "movie";
    private static final String METHOD_TVSERIES = "tvseries";
    private static final String METHOD_SEASON = "season";
    // Filters
    private static final String FILTER_MOVIE = "movie";
    private static final String FILTER_TVSERIES = "tvseries";
    // Parameters
    private static final String PARAM_PROFILE = "profile";
    private static final String PARAM_MEDIAFMT = "mediafmt";
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_STRIPTAGS = "striptags";
    private static final String PARAM_FORMAT = "format";
    private static final String PARAM_CODE = "code";
    private ApiUrl apiUrl;
    private final String format;

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
    public void setProxy(String host, int port, String username, String password) {
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

    protected URLConnection connectSearchTvseriesInfos(String query) throws IOException {
        Map<String, String> params = new LinkedHashMap<String, String>();

        params.put(PARAM_FORMAT, format);
        params.put(PARAM_FILTER, FILTER_TVSERIES);
        params.put("q", query);

        URL url = apiUrl.generateUrl(METHOD_SEARCH, params);
        return WebBrowser.openProxiedConnection(url);
    }

    protected URLConnection connectGetMovieInfos(String allocineId) throws IOException {
        Map<String, String> params = new LinkedHashMap<String, String>();

        params.put(PARAM_CODE, allocineId);
        params.put(PARAM_PROFILE, "large");
        params.put(PARAM_FILTER, FILTER_MOVIE);
        params.put(PARAM_STRIPTAGS, "synopsis,synopsisshort");
        params.put(PARAM_FORMAT, format);
//        params.put(PARAM_MEDIAFMT, "mp4-lc");

        URL url = apiUrl.generateUrl(METHOD_MOVIE, params);
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
