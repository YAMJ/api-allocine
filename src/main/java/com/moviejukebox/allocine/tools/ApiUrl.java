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
package com.moviejukebox.allocine.tools;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ApiUrl {

    private static final Logger LOG = LoggerFactory.getLogger(ApiUrl.class);
    // Base API URL
    private static final String API_URL = "http://api.allocine.fr/rest/v3/";
    private static final String PARAM_PARTNER = "?partner=";
    // Keys
    private String partnerKey;
    private String secretKey;
    // Constants
    private static final String URL_ENCODING = "UTF-8";
    private static final String DATE_FORMAT = "yyyyMMdd";
    private static final String PREFIX_SED = "&sed=";
    private static final String PREFIX_SIG = "&sig=";

    public ApiUrl(String partnerKey, String secretKey) {
        this.partnerKey = partnerKey;
        this.secretKey = secretKey;
    }

    /**
     * Create the URL from the method and a list of parameters
     *
     * @param method
     * @param params
     * @return
     */
    public URL generateUrl(final String method, final Map<String, String> params) {
        // https://github.com/gromez/allocine-api/blob/master/PHP/allocine.class.php

        StringBuilder url;

        String sed = buildSed();
        String paramUrl = buildParams(params);

        url = new StringBuilder(secretKey);
        url.append(paramUrl.substring(1));  // Don't add the "?" at the start of the params
        url.append(PREFIX_SED);
        url.append(sed);
        byte[] sha1code = DigestUtils.sha1(url.toString());

        String sig = encoder(new String(Base64.encodeBase64(sha1code)));

        url = new StringBuilder(API_URL);
        url.append(method);
        url.append(paramUrl);
        url.append(PREFIX_SED).append(sed);
        url.append(PREFIX_SIG).append(sig);

        LOG.trace("URL: " + url.toString());

        try {
            return new URL(url.toString());
        } catch (MalformedURLException ex) {
            LOG.warn("Failed to convert '{}' to an URL, error: {}", url.toString(), ex.getMessage());
            return null;
        }
    }

    /**
     * Encode a string for use in the URL
     *
     * @param toEncode
     * @return
     */
    private String encoder(String toEncode) {
        try {
            return URLEncoder.encode(toEncode, URL_ENCODING);
        } catch (UnsupportedEncodingException ex) {
            LOG.warn("Failed to encode: " + ex.getMessage());
            return "";
        }
    }

    /**
     * Build the date to be used in the URL parameters
     *
     * @return
     */
    private String buildSed() {
        DateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date());
    }

    /**
     * Generate the parameter URL string
     *
     * @param params
     * @return
     */
    private String buildParams(final Map<String, String> params) {
        StringBuilder paramUrl = new StringBuilder();

        // First add the partner key, this is the first parameter, so skip the prefix
        paramUrl.append(PARAM_PARTNER).append(partnerKey);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            paramUrl.append("&").append(entry.getKey());
            paramUrl.append("=").append(encoder(entry.getValue()));
        }
        return paramUrl.toString();
    }
}
