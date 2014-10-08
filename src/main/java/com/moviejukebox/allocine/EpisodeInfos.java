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
package com.moviejukebox.allocine;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moviejukebox.allocine.model.Episode;

/**
 * This is the Episode Search bean for the api.allocine.fr search
 *
 * @author modmax
 */
public class EpisodeInfos extends AbstractBaseInfos {

    private static final long serialVersionUID = 7745674601738810957L;

    @JsonProperty("episode")
    private Episode episode;

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public boolean isValid() {
        if (episode == null) {
            return false;
        }
        return (episode.getCode() > 0);
    }

    public boolean isNotValid() {
        return !this.isValid();
    }

    public int getCode() {
        return this.getCode(episode);
    }
    
    public String getTitle() {
        return this.getTitle(episode);
    }

    public String getOriginalTitle() {
        return this.getOriginalTitle(episode);
    }
    
    public String getSynopsis() {
        if (episode == null) {
            return null;
        }
        return episode.getSynopsis();
    }

    public String getSynopsisShort() {
        if (episode == null) {
            return null;
        }
        return episode.getSynopsisShort();
    }

    public String getOriginalBroadcastDate() {
        if (episode == null) {
            return null;
        }
        return episode.getOriginalBroadcastDate();
    }

    public int getEpisodeNumberSeries() {
        if (episode == null) {
            return -1;
        }
        return episode.getEpisodeNumberSeries();
    }

    public int getEpisodeNumberSeason() {
        if (episode == null) {
            return -1;
        }
        return episode.getEpisodeNumberSeason();
    }

    public Set<MoviePerson> getActors() {
        if (actors == null) {
            parseCasting(episode);
        }
        return actors;
    }

    public Set<MoviePerson> getDirectors() {
        if (directors == null) {
            parseCasting(episode);
        }
        return directors;
    }

    public Set<MoviePerson> getWriters() {
        if (writers == null) {
            parseCasting(episode);
        }
        return writers;
    }
}