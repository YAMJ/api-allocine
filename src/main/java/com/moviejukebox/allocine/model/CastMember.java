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

@JsonRootName("castMember")
public class CastMember extends AbstractJsonUnknownHandleMapping {

    private static final long serialVersionUID = 3303327060524088408L;

    @JsonProperty("person")
    private ShortPerson shortPerson;
    @JsonProperty("activity")
    private Activity activity;
    @JsonProperty("picture")
    private Picture picture;
    @JsonProperty("role")
    private String role;
    @JsonProperty("isLeadActor")
    private boolean isLeadActor = false;

    public ShortPerson getShortPerson() {
        return shortPerson;
    }

    public void setShortPerson(ShortPerson shortPerson) {
        this.shortPerson = shortPerson;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isLeadActor() {
        return isLeadActor;
    }

    public void setLeadActor(boolean isLeadActor) {
        this.isLeadActor = isLeadActor;
    }

    public boolean isActor() {
        if (this.activity != null) {
            return this.activity.isActor();
        }
        return false;
    }

    public boolean isDirector() {
        if (this.activity != null) {
            return this.activity.isDirector();
        }
        return false;
    }

    public boolean isWriter() {
        if (this.activity != null) {
            return this.activity.isWriter();
        }
        return false;
    }
    
    public boolean isCamera() {
        if (this.activity != null) {
            return this.activity.isCamera();
        }
        return false;
    }

    public boolean isProducer() {
        if (this.activity != null) {
            return this.activity.isProducer();
        }
        return false;
    }

    public boolean isCrew() {
        if (this.activity != null) {
            return this.activity.isCrew();
        }
        return false;
    }
}