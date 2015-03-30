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
import java.util.List;

@JsonRootName("person")
public class ShortPerson extends CodeName {

    private static final long serialVersionUID = 100L;

    @JsonProperty("gender")
    private int gender;
    @JsonProperty("birthDate")
    private String birthDate;
    @JsonProperty("activity")
    private List<CodeName> activity;
    @JsonProperty("nationality")
    private List<CodeName> nationality;
    @JsonProperty("picture")
    private Artwork picture;
    @JsonProperty("link")
    private List<Link> link;

    public boolean isMale() {
        return gender == 1;
    }

    public boolean isFemale() {
        return gender == 2;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<CodeName> getActivity() {
        return activity;
    }

    public void setActivity(List<CodeName> activity) {
        this.activity = activity;
    }

    public List<CodeName> getNationality() {
        return nationality;
    }

    public void setNationality(List<CodeName> nationality) {
        this.nationality = nationality;
    }

    public Artwork getPicture() {
        return picture;
    }

    public void setPicture(Artwork picture) {
        this.picture = picture;
    }

    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }

}
