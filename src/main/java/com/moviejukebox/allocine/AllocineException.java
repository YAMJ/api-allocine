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

import java.net.URL;
import org.yamj.api.common.exception.ApiException;
import org.yamj.api.common.exception.ApiExceptionType;

public class AllocineException extends ApiException {

    private static final long serialVersionUID = 2886118816495000659L;

    public AllocineException(ApiExceptionType exceptionType, String response) {
        super(exceptionType, response);
    }

    public AllocineException(ApiExceptionType exceptionType, String response, URL url) {
        super(exceptionType, response, url);
    }

    public AllocineException(ApiExceptionType exceptionType, String response, int responseCode, URL url) {
        super(exceptionType, response, responseCode, url);
    }

    public AllocineException(ApiExceptionType exceptionType, String response, String url) {
        super(exceptionType, response, url);
    }

    public AllocineException(ApiExceptionType exceptionType, String response, int responseCode, String url) {
        super(exceptionType, response, responseCode, url);
    }

    public AllocineException(ApiExceptionType exceptionType, String response, URL url, Throwable cause) {
        super(exceptionType, response, url, cause);
    }

    public AllocineException(ApiExceptionType exceptionType, String response, int responseCode, URL url, Throwable cause) {
        super(exceptionType, response, responseCode, url, cause);
    }

    public AllocineException(ApiExceptionType exceptionType, String response, String url, Throwable cause) {
        super(exceptionType, response, url, cause);
    }

    public AllocineException(ApiExceptionType exceptionType, String response, int responseCode, String url, Throwable cause) {
        super(exceptionType, response, responseCode, url, cause);
    }
}
