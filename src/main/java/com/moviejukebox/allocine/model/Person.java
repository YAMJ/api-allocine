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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.moviejukebox.allocine.model.media.MediaBasic;
import com.moviejukebox.allocine.model.media.MediaPicture;
import com.moviejukebox.allocine.model.media.MediaVideoPerson;
import java.util.ArrayList;
import java.util.List;

@JsonRootName("person")
@JsonIgnoreProperties(value = {"trailerEmbed"})
public class Person extends AbstractJsonMapping {

    private static final long serialVersionUID = 100L;

    @JsonProperty("code")
    private int code;
    @JsonProperty("name")
    private PersonName personName;
    @JsonProperty("realName")
    private String realName;
    @JsonProperty("gender")
    private int gender;
    @JsonProperty("biographyShort")
    private String biographyShort;
    @JsonProperty("biography")
    private String biography;
    @JsonProperty("birthDate")
    private String birthDate;
    @JsonProperty("birthPlace")
    private String birthPlace;
    @JsonProperty("deathDate")
    private String deathDate;
    @JsonProperty("deathPlace")
    private String deathPlace;
    @JsonProperty("picture")
    private Artwork picture;
    @JsonProperty("participation")
    private List<Participation> participations = new ArrayList<>();
    @JsonProperty("festivalAward")
    private List<FestivalAward> festivalAwards = new ArrayList<>();
    @JsonProperty("nationality")
    private List<CodeName> nationality;
    @JsonProperty("activity")
    private List<Activity> activity;
    @JsonProperty("activityShort")
    private String activityShort;
    @JsonProperty("hasTopFilmography")
    private boolean topFilmography;
    @JsonProperty("link")
    private List<Link> link;
    private List<MediaBasic> media;
    @JsonProperty("news")
    private List<News> news;
    @JsonProperty("feature")
    private List<News> features;
    @JsonProperty("statistics")
    private Statistics statistics;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public PersonName getPersonName() {
        return personName;
    }

    public void setPersonName(PersonName personName) {
        this.personName = personName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBiographyShort() {
        return biographyShort;
    }

    public void setBiographyShort(String biographyShort) {
        this.biographyShort = biographyShort;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getDeathPlace() {
        return deathPlace;
    }

    public void setDeathPlace(String deathPlace) {
        this.deathPlace = deathPlace;
    }

    public Artwork getPicture() {
        return picture;
    }

    public void setPicture(Artwork picture) {
        this.picture = picture;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    public List<FestivalAward> getFestivalAwards() {
        return festivalAwards;
    }

    public void setFestivalAwards(List<FestivalAward> festivalAwards) {
        this.festivalAwards = festivalAwards;
    }

    public List<CodeName> getNationality() {
        return nationality;
    }

    public void setNationality(List<CodeName> nationality) {
        this.nationality = nationality;
    }

    public List<Activity> getActivity() {
        return activity;
    }

    public void setActivity(List<Activity> activity) {
        this.activity = activity;
    }

    public String getActivityShort() {
        return activityShort;
    }

    public void setActivityShort(String activityShort) {
        this.activityShort = activityShort;
    }

    public boolean isTopFilmography() {
        return topFilmography;
    }

    public void setTopFilmography(boolean topFilmography) {
        this.topFilmography = topFilmography;
    }

    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }

    public List<MediaBasic> getMedia() {
        return media;
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "class"
    )
    @JsonSubTypes({
        @JsonSubTypes.Type(value = MediaPicture.class, name = "picture"),
        @JsonSubTypes.Type(value = MediaVideoPerson.class, name = "video")
    })
    @JsonSetter("media")
    public void setMedia(List<MediaBasic> media) {
        this.media = media;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<News> getFeatures() {
        return features;
    }

    public void setFeatures(List<News> features) {
        this.features = features;
    }

    @JsonSetter("festivalSection")
    public void setFestivalSection(List<FestivalAward> festivalAwards) {
        this.festivalAwards = festivalAwards;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
}
