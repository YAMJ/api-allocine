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
package com.moviejukebox.allocine.model.media;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.moviejukebox.allocine.model.AbstractJsonMapping;
import com.moviejukebox.allocine.model.PersonMedia;

public class Subject extends AbstractJsonMapping {

    private PersonMedia media;

    public PersonMedia getMedia() {
        return media;
    }

    @JsonSetter("movie")
    public void setMovie(PersonMedia media) {
        this.media = media;
        this.media.setType("movie");
    }

    @JsonSetter("tvseries")
    public void setTVSeries(PersonMedia media) {
        this.media = media;
        this.media.setType("tvseries");
    }

}
