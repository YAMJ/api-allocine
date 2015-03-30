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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.moviejukebox.allocine.model.media.MediaBasic;
import com.moviejukebox.allocine.model.wrapper.DefaultMediaWrapper;
import java.util.List;

@JsonRootName("episode")
@JsonIgnoreProperties(value = {"trailerEmbed"})
public class Episode extends AbstractBaseMapping {

    private static final long serialVersionUID = 100L;

    @JsonProperty("originalBroadcastDate")
    private String originalBroadcastDate;
    @JsonProperty("episodeNumberSeries")
    private int episodeNumberSeries;
    @JsonProperty("episodeNumberSeason")
    private int episodeNumberSeason;
    @JsonProperty("parentSeries")
    private CodeName parentSeries;
    @JsonProperty("parentSeason")
    private CodeName parentSeason;
    @JsonProperty("picture")
    private Artwork picture;
    @JsonProperty("trailer")
    private Trailer trailer;
    @JsonProperty("broadcast")
    private List<Broadcast> broadcast;
    @JsonProperty("link")
    private List<Link> link;
    private MediaBasic defaultMedia;

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

    public CodeName getParentSeries() {
        return parentSeries;
    }

    public void setParentSeries(CodeName parentSeries) {
        this.parentSeries = parentSeries;
    }

    public CodeName getParentSeason() {
        return parentSeason;
    }

    public void setParentSeason(CodeName parentSeason) {
        this.parentSeason = parentSeason;
    }

    public Artwork getPicture() {
        return picture;
    }

    public void setPicture(Artwork picture) {
        this.picture = picture;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public List<Broadcast> getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(List<Broadcast> broadcast) {
        this.broadcast = broadcast;
    }

    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }

    public MediaBasic getDefaultMedia() {
        return defaultMedia;
    }

    @JsonSetter("defaultMedia")
    public void setDefaultMedia(DefaultMediaWrapper defaultMedia) {
        this.defaultMedia = defaultMedia.getMedia();
    }

}
