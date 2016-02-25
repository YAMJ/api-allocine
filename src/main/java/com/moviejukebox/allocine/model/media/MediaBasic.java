/*
 *      Copyright (c) 2004-2016 YAMJ Members
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
package com.moviejukebox.allocine.model.media;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.moviejukebox.allocine.model.AbstractJsonMapping;
import com.moviejukebox.allocine.model.Artwork;
import com.moviejukebox.allocine.model.CodeName;

@JsonIgnoreProperties(value = {"trailerEmbed"})
public class MediaBasic extends AbstractJsonMapping {

    private static final long serialVersionUID = -3335090963467492546L;
    private static final int POSTER_MEDIA_CODE = 31001;

    @JsonProperty("class")
    private String mediaClass;
    @JsonProperty("code")
    private Long code;
    @JsonProperty("rcode")
    private Long rcode;
    @JsonProperty("type")
    private CodeName mediaType;
    @JsonProperty("title")
    private String title;
    @JsonProperty("thumbnail")
    private Artwork thumbnail;

    public String getMediaClass() {
        return mediaClass;
    }

    public void setMediaClass(String mediaClass) {
        this.mediaClass = mediaClass;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getRcode() {
        return rcode;
    }

    public void setRcode(Long rcode) {
        this.rcode = rcode;
    }

    public CodeName getMediaType() {
        return mediaType;
    }

    public void setMediaType(CodeName mediaType) {
        this.mediaType = mediaType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artwork getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Artwork thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isPoster() {
        if (this.mediaType != null) {
            return this.mediaType.getCode() == POSTER_MEDIA_CODE;
        }
        return false;
    }
}
