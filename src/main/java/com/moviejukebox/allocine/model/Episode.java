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
import com.moviejukebox.allocine.tools.HtmlTools;

@JsonRootName("episode")
public class Episode extends AbstractJsonUnknownHandleMapping {

    private static final long serialVersionUID = 7597888938988246976L;

    @JsonProperty("code")
    private int code;
    @JsonProperty("title")
    private String title;
    @JsonProperty("originalTitle")
    private String originalTitle;
    @JsonProperty("synopsis")
    private String synopsis;
    @JsonProperty("originalBroadcastDate")
    private String originalBroadcastDate;
    @JsonProperty("episodeNumberSeries")
    private int episodeNumberSeries;
    @JsonProperty("episodeNumberSeason")
    private int episodeNumberSeason;
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getSynopsis() {
        return HtmlTools.removeLineFeeds(HtmlTools.removeHtmlTags(synopsis));
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

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
