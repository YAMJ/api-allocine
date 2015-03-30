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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.moviejukebox.allocine.model.wrapper.ChannelWrapper;

@JsonRootName("broadcast")
public class Broadcast extends AbstractJsonMapping {

    private static final long serialVersionUID = 100L;

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
    private String csaShortLabel;
    @JsonProperty("CSALongLabel")
    private String csaLongLabel;
    @JsonProperty("HD")
    private boolean hd;
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

    public String getCsaShortLabel() {
        return csaShortLabel;
    }

    public void setCsaShortLabel(String csaShortLabel) {
        this.csaShortLabel = csaShortLabel;
    }

    public String getCsaLongLabel() {
        return csaLongLabel;
    }

    public void setCsaLongLabel(String csaLongLabel) {
        this.csaLongLabel = csaLongLabel;
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

    @JsonSetter("parentChannel")
    public void setParentChannel(ChannelWrapper cw) {
        this.parentChannel = cw.getChannel();
    }
}
