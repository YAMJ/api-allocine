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
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

public class News extends AbstractJsonMapping {

    private static final long serialVersionUID = 100L;

    @JsonProperty("code")
    private String code;
    private String publication;
    @JsonProperty("title")
    private String title;
    private String displayMode;
    @JsonProperty("pageCount")
    private Integer pageCount;
    @JsonProperty("category")
    private List<CodeName> category;
    @JsonProperty("picture")
    private Artwork picture;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPublication() {
        return publication;
    }

    @JsonSetter("publication")
    public void setPublication(AllocineDate publication) {
        this.publication = publication.getDateStart();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisplayMode() {
        return displayMode;
    }

    @JsonSetter("displayMode")
    public void setDisplayMode(CodeName displayMode) {
        this.displayMode = displayMode.getName();
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<CodeName> getCategory() {
        return category;
    }

    public void setCategory(List<CodeName> category) {
        this.category = category;
    }

    public Artwork getPicture() {
        return picture;
    }

    public void setPicture(Artwork picture) {
        this.picture = picture;
    }

}
