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
package com.moviejukebox.allocine.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonRootName("statistics")
public class Statistics {

    private static final long serialVersionUID = 1L;

    private final Map<String, Object> stats = new HashMap<>();
    @JsonProperty("rating")
    private List<Rating> ratings;

    @JsonAnySetter
    public void addStat(String key, Object value) {
        stats.put(key, value);
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public boolean hasStatistic(String statisticName) {
        return stats.containsKey(statisticName);
    }

    public Object getStatistic(String statisticName) {
        return stats.get(statisticName);
    }

    public Integer getIntegerStatistic(String statisticName) {
        return getStatistic(statisticName, Integer.class);
    }

    public Double getDoubleStatistic(String statisticName) {
        return getStatistic(statisticName, Double.class);
    }

    public <T> T getStatistic(String statisticName, Class<T> clazz) {
        return clazz.cast(stats.get(statisticName));
    }
}
