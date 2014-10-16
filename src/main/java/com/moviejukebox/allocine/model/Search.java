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

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;

public class Search extends AbstractJsonUnknownHandleMapping {

    private static final long serialVersionUID = -9017972889712498870L;

    @JsonProperty("feed")
    private Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public boolean isValid() {
        if (feed == null) {
            return false;
        }
        if (feed.getTotalResults() <= 0) {
            return false;
        }
        return true;
    }

    public long getTotalResults() {
        if (feed == null) {
            return 0;
        }
        return feed.getTotalResults();
    }

    public List<Movie> getMovies() {
        if (feed == null) {
            return Collections.emptyList();
        }
        return feed.getMovies();
    }

    public List<TvSeries> getTvSeries() {
        if (feed == null) {
            return Collections.emptyList();
        }
        return feed.getTvSeries();
    }

    public List<ShortPerson> getPersons() {
        if (feed == null) {
            return Collections.emptyList();
        }
        return feed.getPersons();
    }
}
