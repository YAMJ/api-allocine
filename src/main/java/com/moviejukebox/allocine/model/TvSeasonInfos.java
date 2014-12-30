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

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * This is the Movie Search bean for the api.allocine.fr search
 *
 * @author Yves.Blusseau
 */
public class TvSeasonInfos extends AbstractBaseInfos {

    private static final long serialVersionUID = 1357655581772310729L;

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
    
    public Set<String> getPosterUrls() {
        return this.getPosterUrls(season);
    }
}
