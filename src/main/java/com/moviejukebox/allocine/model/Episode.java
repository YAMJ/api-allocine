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

@JsonRootName("episode")
public class Episode extends AbstractBaseMapping {

    private static final long serialVersionUID = 7597888938988246976L;

    @JsonProperty("originalBroadcastDate")
    private String originalBroadcastDate;
    @JsonProperty("episodeNumberSeries")
    private int episodeNumberSeries;
    @JsonProperty("episodeNumberSeason")
    private int episodeNumberSeason;

    public String getOriginalBroadcastDate() {
        return originalBroadcastDate;
    }

    public void setOriginalBroadcastDate(String originalBroadcastDate) {
        this.originalBroadcastDate = originalBroadcastDate;
    }

    public int getEpisodeNumberSeries() {
        return episodeNumberSeries;
    }

    public void setEpisodeNumberSeries(int episodeNumberSeries) {
        this.episodeNumberSeries = episodeNumberSeries;
    }

    public int getEpisodeNumberSeason() {
        return episodeNumberSeason;
    }

    public void setEpisodeNumberSeason(int episodeNumberSeason) {
        this.episodeNumberSeason = episodeNumberSeason;
    }
}
