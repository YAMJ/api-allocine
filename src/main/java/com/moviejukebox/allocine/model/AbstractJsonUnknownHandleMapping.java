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
package com.moviejukebox.allocine.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public abstract class AbstractJsonUnknownHandleMapping extends AbstractJsonMapping {

    @JsonIgnore
    private static final Logger LOG = LoggerFactory.getLogger(AbstractJsonUnknownHandleMapping.class);

    /**
     * Handle unknown properties
     *
     * @param key
     * @param value
     */
    @JsonAnySetter
    @Override
    protected void handleUnknown(String key, Object value) {
        if (LOG.isTraceEnabled()) {
            StringBuilder unknown = new StringBuilder(this.getClass().getSimpleName());
            unknown.append(": Unknown property='").append(key);
            unknown.append("' value='").append(value).append("'");
            LOG.trace(unknown.toString());
        }
    }
}
