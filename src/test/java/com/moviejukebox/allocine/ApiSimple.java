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

import com.moviejukebox.allocine.tools.WebBrowser;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

public class ApiSimple {

    private static String mainPartnerKey = "100043982026";
    private static String mainSecretKey = "29d185d98c984a359e6e6f26a0474269";
    private static Map<String, String> ids = new LinkedHashMap<String, String>();

    public static void main(String[] args) throws IOException {
        SimpleAllocineApi api = new SimpleAllocineApi(mainPartnerKey, mainSecretKey);
        com.moviejukebox.allocine.ApiNew.NewAllocineApi tApi = new ApiNew.NewAllocineApi(mainPartnerKey, mainSecretKey);

        ids.put("197440", "Adieu Berthe ou l'enterrement de mémé");
//        ids.put("54343", "L'Odyssée de Pi");
//        ids.put("45866", "Salut Berthe!");
//        ids.put("136190", "Iron Man 2");

        for (Map.Entry<String, String> entry : ids.entrySet()) {
            String stringUrl = api.get(entry.getKey());
            String tempUrl = tApi.get(entry.getKey()).toString();
            System.out.println("ID: " + entry.getKey() + " Title '" + entry.getValue() + "' \nURL: " + stringUrl);
            System.out.println("URL: " + tempUrl);

            dumpUrl(stringUrl);
            dumpUrl(tempUrl);
        }
//        System.out.println("SEARCH RESPONSE: " + api.search("Avatar"));
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
            System.out.println(writer.toString());
        } catch (IOException ex) {
            System.out.println("It broke! " + ex.getMessage());
        }
    }

    private static URL createURL(String stringUrl) {
        try {
            return new URL(stringUrl);
        } catch (MalformedURLException ex) {
            return null;
        }
    }

    private static class SimpleAllocineApi {

        private static final String API_URL = "http://api.allocine.fr/rest/v3/";
        private String partnerKey;
        private String secretKey;
        private static final String METHOD_MOVIE = "movie";
        private static final String METHOD_SEARCH = "search";

        public SimpleAllocineApi(String partnerKey, String secretKey) {
            this.partnerKey = partnerKey;
            this.secretKey = secretKey;
        }

        public String createUrl(final String method, final Map<String, String> params) {
            // https://github.com/gromez/allocine-api/blob/master/PHP/allocine.class.php

            StringBuilder url;

            String sed = buildSed();
            String paramUrl = buildParams(params);
            System.out.println("Params1: " + paramUrl);

            url = new StringBuilder(secretKey);
            url.append(paramUrl);
            url.append("&sed=");
            url.append(sed);
            System.out.println("New: " + url.toString());
            byte[] sha1code = DigestUtils.sha1(url.toString());

            String sig = encoder(new String(Base64.encodeBase64(sha1code)));

            url = new StringBuilder(API_URL);
            url.append(method);
            url.append("?").append(paramUrl);
            url.append("&sed=").append(sed);
            url.append("&sig=").append(sig);

//            System.out.println("URL: " + url.toString());
            return url.toString();

        }

        private String encoder(String toEncode) {
            try {
                return URLEncoder.encode(toEncode, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                System.out.println("Failed to encode: " + ex.getMessage());
                return "";
            }
        }

        private String buildSed() {
            DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            return sdf.format(new Date());
        }

        private String buildParams(final Map<String, String> params) {
            StringBuilder paramUrl = new StringBuilder();
            boolean first = Boolean.TRUE;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (first) {
                    first = Boolean.FALSE;
                } else {
                    paramUrl.append("&");
                }
                paramUrl.append(entry.getKey()).append("=").append(encoder(entry.getValue()));
            }
            return paramUrl.toString();
        }

        public String get(String id) {
            Map<String, String> params = new LinkedHashMap<String, String>();
            params.put("partner", partnerKey);
            params.put("code", id);
            params.put("profile", "large");
            params.put("filter", "movie");
            params.put("striptags", "synopsis,synopsisshort");
            params.put("format", "json");

            return createUrl(METHOD_MOVIE, params);
        }

        public String search(String query) {
            Map<String, String> params = new LinkedHashMap<String, String>();
            params.put("partner", partnerKey);
            params.put("q", query);
            params.put("format", "json");
            params.put("filter", "movie");

            return createUrl(METHOD_SEARCH, params);
        }
    }
}