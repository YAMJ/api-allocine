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
package com.moviejukebox.allocine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;

public class Search extends AbstractJsonMapping {

    private static final long serialVersionUID = 100L;

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

        return feed.getTotalResults() > 0;
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
