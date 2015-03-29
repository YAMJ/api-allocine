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
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.ArrayList;
import java.util.List;

@JsonRootName("tvseries")
public class TvSeries extends AbstractBaseMapping {

    private static final long serialVersionUID = 6553404486681341006L;

    @JsonProperty("yearStart")
    private int yearStart;
    @JsonProperty("yearEnd")
    private int yearEnd;
    @JsonProperty("originalChannel")
    private OriginalChannel originalChannel;
    @JsonProperty("seasonCount")
    private int seasonCount;
    @JsonProperty("season")
    private List<Season> seasonList = new ArrayList<>();
    @JsonProperty("festivalAward")
    private List<FestivalAward> festivalAwards = new ArrayList<>();
    @JsonProperty("seriesType")
    private CodeName seriesType;
    @JsonProperty("keywords")
    private String keywords;
    private String originalBroadcast;
    @JsonProperty("formatTime")
    private int formatTime;
    @JsonProperty("productionStatus")
    private CodeName productionStatus;
    @JsonProperty("broadcast")
    private List<Broadcast> broadcast;
    @JsonProperty("lastSeasonNumber")
    private int lastSeasonNumber;
    @JsonProperty("episodeCount")
    private int episodeCount;
    @JsonProperty("topBanner")
    private Picture topBanner;
    @JsonProperty("name")
    private String name;

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

    public OriginalChannel getOriginalChannel() {
        return originalChannel;
    }

    public void setOriginalChannel(OriginalChannel originalChannel) {
        this.originalChannel = originalChannel;
    }

    public int getSeasonCount() {
        return seasonCount;
    }

    public void setSeasonCount(int seasonCount) {
        this.seasonCount = seasonCount;
    }

    public List<Season> getSeasonList() {
        return seasonList;
    }

    public void setSeasonList(List<Season> seasonList) {
        this.seasonList = seasonList;
    }

    public List<FestivalAward> getFestivalAwards() {
        return festivalAwards;
    }

    public void setFestivalAwards(List<FestivalAward> festivalAwards) {
        this.festivalAwards = festivalAwards;
    }

    public CodeName getSeriesType() {
        return seriesType;
    }

    public void setSeriesType(CodeName seriesType) {
        this.seriesType = seriesType;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getOriginalBroadcast() {
        return originalBroadcast;
    }

    @JsonSetter("originalBroadcast")
    public void setOriginalBroadcast(AllocineDate originalBroadcast) {
        this.originalBroadcast = originalBroadcast.getDateStart();
    }

    public int getFormatTime() {
        return formatTime;
    }

    public void setFormatTime(int formatTime) {
        this.formatTime = formatTime;
    }

    public CodeName getProductionStatus() {
        return productionStatus;
    }

    public void setProductionStatus(CodeName productionStatus) {
        this.productionStatus = productionStatus;
    }

    public List<Broadcast> getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(List<Broadcast> broadcast) {
        this.broadcast = broadcast;
    }

    public int getLastSeasonNumber() {
        return lastSeasonNumber;
    }

    public void setLastSeasonNumber(int lastSeasonNumber) {
        this.lastSeasonNumber = lastSeasonNumber;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    public Picture getTopBanner() {
        return topBanner;
    }

    public void setTopBanner(Picture topBanner) {
        this.topBanner = topBanner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
