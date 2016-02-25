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
package com.moviejukebox.allocine.model.wrapper;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.moviejukebox.allocine.model.AbstractJsonMapping;
import com.moviejukebox.allocine.model.media.MediaBasic;
import com.moviejukebox.allocine.model.media.MediaPicture;
import com.moviejukebox.allocine.model.media.MediaVideo;

public class DefaultMediaWrapper extends AbstractJsonMapping {

    private static final long serialVersionUID = 8494944042108658875L;
    
    private MediaBasic media;

    public MediaBasic getMedia() {
        return media;
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "class"
    )
    @JsonSubTypes({
        @JsonSubTypes.Type(value = MediaPicture.class, name = "picture"),
        @JsonSubTypes.Type(value = MediaVideo.class, name = "video")
    })
    @JsonSetter("media")
    public void setMedia(MediaBasic media) {
        this.media = media;
    }

}
