/*
 *      Copyright (c) 2004-2015 YAMJ Members
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
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiNew {

    private static final Logger LOG = LoggerFactory.getLogger(ApiNew.class);
    private static String mainPartnerKey = "100043982026";
    private static String mainSecretKey = "29d185d98c984a359e6e6f26a0474269";
    private static Map<String, String> ids = new LinkedHashMap<String, String>();

    public static void main(String[] args) throws IOException, InterruptedException {
        NewAllocineApi api = new NewAllocineApi(mainPartnerKey, mainSecretKey);

        ids.put("197440", "Adieu Berthe ou l'enterrement de mémé");
        ids.put("54343", "L'Odyssée de Pi");
        ids.put("45866", "Salut Berthe!");
        ids.put("136190", "Iron Man 2");
        ids.put("27405", "Oblivion");

        LOG.info("**************************************************");
        String url;
        for (Map.Entry<String, String> entry : ids.entrySet()) {
            LOG.info("ID: '{}' Title '{}'", entry.getKey(), entry.getValue());
            LOG.info("Getting info for ID '{}'", entry.getKey());
            url = api.get(entry.getKey());
            LOG.info("URL: {}", url.toString());
            dumpUrl(url);
            LOG.info("----------");
            LOG.info("Searching for '{}'", entry.getValue());
            url = api.search(entry.getValue());
            LOG.info("URL: {}", url.toString());
            dumpUrl(url);
            LOG.info("**************************************************");
        }
    }

    public static void dumpUrl(String url) {
        dumpUrl(createURL(url));
    }

    public static void dumpUrl(URL url) {
        try {
            URLConnection conn = WebBrowser.openProxiedConnection(url);
            InputStream stream = conn.getInputStream();
            StringWriter writer = new StringWriter();
            IOUtils.copy(stream, writer, "UTF-8");
            LOG.info(writer.toString());
        } catch (IOException ex) {
            LOG.error("Error: {}", ex.getMessage());
        }
    }

    private static URL createURL(String stringUrl) {
        try {
            return new URL(stringUrl);
        } catch (MalformedURLException ex) {
            return null;
        }
    }

    public static class NewAllocineApi {

        ApiUrl apiUrl;
        private static final String METHOD_MOVIE = "movie";
        private static final String METHOD_SEARCH = "search";

        public NewAllocineApi(String partnerKey, String secretKey) {
            apiUrl = new ApiUrl(mainPartnerKey, mainSecretKey);
        }

        public String get(String id) {
            Map<String, String> params = new LinkedHashMap<String, String>();
            params.put("code", id);
            params.put("profile", "large");
            params.put("filter", "movie");
            params.put("striptags", "synopsis,synopsisshort");
            params.put("format", "json");

            return apiUrl.generateUrl(METHOD_MOVIE, params);
        }

        public String search(String query) {
            Map<String, String> params = new LinkedHashMap<String, String>();
            params.put("q", query.toLowerCase());
            params.put("format", "json");
            params.put("filter", "movie");

            return apiUrl.generateUrl(METHOD_SEARCH, params);
        }
    }
}