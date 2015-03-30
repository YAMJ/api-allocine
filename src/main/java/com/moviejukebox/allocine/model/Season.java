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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.moviejukebox.allocine.model.wrapper.ChannelWrapper;
import java.util.ArrayList;
import java.util.List;

@JsonRootName("season")
@JsonIgnoreProperties(value = {"trailerEmbed"})
public class Season extends AbstractBaseMapping {

    private static final long serialVersionUID = -9173083320025101754L;

    @JsonProperty("seasonNumber")
    private int seasonNumber;
    @JsonProperty("yearStart")
    private int yearStart;
    @JsonProperty("yearEnd")
    private int yearEnd;
    @JsonProperty("episodeCount")
    private int episodeCount;
    @JsonProperty("episode")
    private List<Episode> episodeList = new ArrayList<>();
    @JsonProperty("link")
    private List<Link> link;
    @JsonProperty("productionStatus")
    private CodeName productionStatus;
    @JsonProperty("hasLocalBroadcast")
    private boolean localBroadcast;
    @JsonProperty("parentSeries")
    private TvSeries parentSeries;
    private Channel originalChannel;
    @JsonProperty("picture")
    private Artwork picture;
    @JsonProperty("hasBluRay")
    private boolean bluRay;
    @JsonProperty("broadcast")
    private List<Broadcast> broadcast;

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public int getYearStart() {
        return yearStart;
    }

    public void setYearStart(int yearStart) {
        this.yearStart = yearStart;
    }

    public int getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(int yearEnd) {
        this.yearEnd = yearEnd;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }

    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }

    public CodeName getProductionStatus() {
        return productionStatus;
    }

    public void setProductionStatus(CodeName productionStatus) {
        this.productionStatus = productionStatus;
    }

    public boolean isLocalBroadcast() {
        return localBroadcast;
    }

    public void setLocalBroadcast(boolean localBroadcast) {
        this.localBroadcast = localBroadcast;
    }

    public TvSeries getParentSeries() {
        return parentSeries;
    }

    public void setParentSeries(TvSeries parentSeries) {
        this.parentSeries = parentSeries;
    }

    public Channel getOriginalChannel() {
        return originalChannel;
    }

    public void setOriginalChannel(Channel originalChannel) {
        this.originalChannel = originalChannel;
    }

    public Artwork getPicture() {
        return picture;
    }

    public void setPicture(Artwork picture) {
        this.picture = picture;
    }

    public boolean isBluRay() {
        return bluRay;
    }

    public void setBluRay(boolean bluRay) {
        this.bluRay = bluRay;
    }

    public List<Broadcast> getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(List<Broadcast> broadcast) {
        this.broadcast = broadcast;
    }

    @JsonSetter("originalChannel")
    public void setOriginalChannel(ChannelWrapper cw) {
        this.originalChannel = cw.getChannel();
    }



}
