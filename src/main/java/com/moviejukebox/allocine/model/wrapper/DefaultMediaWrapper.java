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
package com.moviejukebox.allocine.model.wrapper;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.moviejukebox.allocine.model.media.MediaBasic;
import com.moviejukebox.allocine.model.media.MediaPicture;
import com.moviejukebox.allocine.model.media.MediaVideo;

public class DefaultMediaWrapper {

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
