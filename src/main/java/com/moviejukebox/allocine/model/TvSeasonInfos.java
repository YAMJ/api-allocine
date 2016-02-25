/*
 *      Copyright (c) 2004-2016 YAMJ Members
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
import java.util.*;

/**
 * This is the Movie Search bean for the api.allocine.fr search
 *
 * @author Yves.Blusseau
 */
public class TvSeasonInfos extends AbstractBaseInfos {

    private static final long serialVersionUID = 100L;

    @JsonProperty("season")
    private Season season;

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public boolean isValid() {
        if (season == null) {
            return false;
        }
        return season.getCode() > 0;
    }

    public boolean isNotValid() {
        return !this.isValid();
    }

    public int getCode() {
        if (season == null) {
            return -1;
        }
        return season.getCode();
    }

    public int getYearStart() {
        if (season == null) {
            return 0;
        }
        return season.getYearStart();
    }

    public int getYearEnd() {
        if (season == null) {
            return 0;
        }
        return season.getYearEnd();
    }

    public int getSeasonNumber() {
        if (season == null) {
            return -1;
        }
        return season.getSeasonNumber();
    }

    public List<Episode> getEpisodeList() {
        if (season == null) {
            return Collections.emptyList();
        }
        return season.getEpisodeList();
    }

    public Episode getEpisode(int numEpisode) {
        Episode episode = null;
        for (Episode checkEpisode : this.getEpisodeList()) {
            if (checkEpisode.getEpisodeNumberSeason() == numEpisode) {
                episode = checkEpisode;
                break;
            }
        }
        return episode;
    }

    public Set<MoviePerson> getActors() {
        return this.getActors(season);
    }

    public Set<MoviePerson> getDirectors() {
        return this.getDirectors(season);
    }

    public Set<MoviePerson> getWriters() {
        return this.getWriters(season);
    }

    public Set<MoviePerson> getCamera() {
        return this.getCamera(season);
    }

    public Set<MoviePerson> getProducers() {
        return this.getProducers(season);
    }

    public Map<String, Long> getPosters() {
        return this.getPosters(season);
    }
}
