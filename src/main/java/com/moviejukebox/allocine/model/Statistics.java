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

@JsonRootName("statistics")
public class Statistics extends AbstractJsonMapping {

    private static final long serialVersionUID = -228388571068687852L;
    
    @JsonProperty("pressRating")
    private double pressRating;
    @JsonProperty("userRating")
    private double userRating;
    @JsonProperty("rankTopMovie")
    private long rankTopMovie;
    @JsonProperty("variationTopMovie")
    private long variationTopMovie;

    public double getPressRating() {
        return pressRating;
    }

    public void setPressRating(double pressRating) {
        this.pressRating = pressRating;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public long getRankTopMovie() {
        return rankTopMovie;
    }

    public void setRankTopMovie(long rankTopMovie) {
        this.rankTopMovie = rankTopMovie;
    }
}
