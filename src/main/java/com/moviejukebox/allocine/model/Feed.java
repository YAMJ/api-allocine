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
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;

@JsonRootName("feed")
public class Feed extends AbstractJsonUnknownHandleMapping {

    private static final long serialVersionUID = 6122348929992079547L;
    
    @JsonProperty("totalResults")
    private long totalResults = -1;
    @JsonProperty("movie")
    private List<Movie> movies = new ArrayList<Movie>();
    @JsonProperty("tvseries")
    private List<TvSeries> tvseries = new ArrayList<TvSeries>();
    @JsonProperty("person")
    private List<ShortPerson> persons = new ArrayList<ShortPerson>();

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<TvSeries> getTvSeries() {
        return tvseries;
    }

    public void setTvSeries(List<TvSeries> tvseries) {
        this.tvseries = tvseries;
    }

    public List<ShortPerson> getPersons() {
        return persons;
    }

    public void setPersons(List<ShortPerson> persons) {
        this.persons = persons;
    }
}
