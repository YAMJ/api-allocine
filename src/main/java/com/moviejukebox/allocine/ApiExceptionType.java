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

/**
 * Enumeration for the possible errors returned by the API
 *
 * @author Stuart.Boston
 */
public enum ApiExceptionType {

    /**
     * Unknown error occured
     */
    UNKNOWN_CAUSE,
    /**
     * URL is invalid
     */
    INVALID_URL,
    /**
     * The ID was not found
     */
    ID_NOT_FOUND,
    /**
     * Mapping failed from target to internal objects
     */
    MAPPING_FAILED,
    /**
     * Error connecting to the service
     */
    CONNECTION_ERROR,
    /**
     * Image was invalid
     */
    INVALID_IMAGE,
    /**
     * Autorisation rejected
     */
    AUTHORISATION_FAILURE,
    /**
     * Page not found
     */
    HTTP_404_ERROR,
    /**
     * Service Unavailable, usually temporary
     */
    HTTP_503_ERROR;

}
