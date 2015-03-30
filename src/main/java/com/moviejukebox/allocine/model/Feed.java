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
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;

@JsonRootName("feed")
public class Feed extends AbstractJsonMapping {

    private static final long serialVersionUID = 100L;

    @JsonProperty("page")
    private int page = -1;
    @JsonProperty("count")
    private int count = -1;
    @JsonProperty("totalResults")
    private long totalResults = -1;
    @JsonProperty("movie")
    private List<Movie> movies = new ArrayList<>();
    @JsonProperty("tvseries")
    private List<TvSeries> tvseries = new ArrayList<>();
    @JsonProperty("person")
    private List<ShortPerson> persons = new ArrayList<>();
    @JsonProperty("results")
    private List<TypeValue> results;

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<TvSeries> getTvseries() {
        return tvseries;
    }

    public void setTvseries(List<TvSeries> tvseries) {
        this.tvseries = tvseries;
    }

    public List<TypeValue> getResults() {
        return results;
    }

    public void setResults(List<TypeValue> results) {
        this.results = results;
    }
}
