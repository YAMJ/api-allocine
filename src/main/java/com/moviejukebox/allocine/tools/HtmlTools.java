/*
 *      Copyright (c) 2004-2016 YAMJ Members
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
package com.moviejukebox.allocine.tools;

public class HtmlTools {

    private HtmlTools() {
        throw new UnsupportedOperationException("Class cannot be initialised");
    }

    public static String removeLineFeeds(final String src) {
        if (src == null) {
            return null;
        }
        return src.replaceAll("\\r+", "\n").replaceAll("\\n+", " ").replaceAll("\\s+", " ").trim();
    }

    public static String removeHtmlTags(final String src) {
        return replaceHtmlTags(src, "");
    }

    public static String replaceHtmlTags(final String src, final String replacement) {
        if (src == null) {
            return null;
        }
        return src.replaceAll("\\<.*?>", replacement);
    }
}
