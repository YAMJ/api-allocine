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

@JsonRootName("broadcast")
public class Broadcast extends AbstractJsonMapping {

    @JsonProperty("country")
    private CodeName country;
    @JsonProperty("channel")
    private CodeName channel;
    @JsonProperty("new")
    private boolean newBroadcast;
    @JsonProperty("datetime")
    private String dateTime;
    @JsonProperty("multiVersion")
    private int multiVersion;
    @JsonProperty("onShow")
    private OnShow onShow;
    @JsonProperty("code")
    private Long code;
    @JsonProperty("picture")
    private Artwork picture;
    @JsonProperty("CSAShortLabel")
    private String CSAShortLabel;
    @JsonProperty("CSALongLabel")
    private String CSALongLabel;
    @JsonProperty("HD")
    private boolean hd;
    @JsonProperty("parentChannel")
    private Channel parentChannel;

    public CodeName getCountry() {
        return country;
    }

    public void setCountry(CodeName country) {
        this.country = country;
    }

    public CodeName getChannel() {
        return channel;
    }

    public void setChannel(CodeName channel) {
        this.channel = channel;
    }

    public boolean isNewBroadcast() {
        return newBroadcast;
    }

    public void setNewBroadcast(boolean newBroadcast) {
        this.newBroadcast = newBroadcast;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getMultiVersion() {
        return multiVersion;
    }

    public void setMultiVersion(int multiVersion) {
        this.multiVersion = multiVersion;
    }

    public OnShow getOnShow() {
        return onShow;
    }

    public void setOnShow(OnShow onShow) {
        this.onShow = onShow;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Artwork getPicture() {
        return picture;
    }

    public void setPicture(Artwork picture) {
        this.picture = picture;
    }

    public String getCSAShortLabel() {
        return CSAShortLabel;
    }

    public void setCSAShortLabel(String CSAShortLabel) {
        this.CSAShortLabel = CSAShortLabel;
    }

    public String getCSALongLabel() {
        return CSALongLabel;
    }

    public void setCSALongLabel(String CSALongLabel) {
        this.CSALongLabel = CSALongLabel;
    }

    public boolean isHd() {
        return hd;
    }

    public void setHd(boolean hd) {
        this.hd = hd;
    }

    public Channel getParentChannel() {
        return parentChannel;
    }

    public void setParentChannel(Channel parentChannel) {
        this.parentChannel = parentChannel;
    }
}
