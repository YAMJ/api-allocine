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
package com.moviejukebox.allocine.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.moviejukebox.allocine.model.AllocineDate;
import com.moviejukebox.allocine.model.CodeNameOriginal;
import com.moviejukebox.allocine.model.CodeNameShort;
import com.moviejukebox.allocine.model.Statistics;

public class MediaVideo extends MediaBasic {

    @JsonProperty("version")
    private CodeNameOriginal version;
    @JsonProperty("runtime")
    private int runtime;
    @JsonProperty("statistics")
    private Statistics statistics;
    @JsonProperty("titleShort")
    private String titleShort;
    @JsonProperty("acShow")
    private CodeNameShort acShow;
    private String publication;

    public CodeNameOriginal getVersion() {
        return version;
    }

    public void setVersion(CodeNameOriginal version) {
        this.version = version;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public String getTitleShort() {
        return titleShort;
    }

    public void setTitleShort(String titleShort) {
        this.titleShort = titleShort;
    }

    public CodeNameShort getAcShow() {
        return acShow;
    }

    public void setAcShow(CodeNameShort acShow) {
        this.acShow = acShow;
    }

    public String getPublication() {
        return publication;
    }

    @JsonSetter("publication")
    public void setPublication(AllocineDate publication) {
        this.publication = publication.getDateStart();
    }
}
