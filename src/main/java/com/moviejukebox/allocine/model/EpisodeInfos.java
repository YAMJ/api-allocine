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
import java.util.Set;

/**
 * This is the Episode Search bean for the api.allocine.fr search
 *
 * @author modmax
 */
public class EpisodeInfos extends AbstractBaseInfos {

    private static final long serialVersionUID = 100L;

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
        return episode.getCode() > 0;
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
        return this.getActors(episode);
    }

    public Set<MoviePerson> getDirectors() {
        return this.getDirectors(episode);
    }

    public Set<MoviePerson> getWriters() {
        return this.getWriters(episode);
    }

    public Set<MoviePerson> getCamera() {
        return this.getCamera(episode);
    }

    public Set<MoviePerson> getProducers() {
        return this.getProducers(episode);
    }
}
