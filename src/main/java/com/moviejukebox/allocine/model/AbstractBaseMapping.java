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

import com.fasterxml.jackson.annotation.*;
import com.moviejukebox.allocine.model.media.MediaBasic;
import com.moviejukebox.allocine.model.media.MediaPicture;
import com.moviejukebox.allocine.model.media.MediaVideo;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBaseMapping extends AbstractJsonMapping {

    private static final long serialVersionUID = -8874020449926781406L;
    
    @JsonProperty("code")
    private int code;
    @JsonProperty("title")
    private String title;
    @JsonProperty("originalTitle")
    private String originalTitle;
    @JsonProperty("synopsis")
    private String synopsis;
    @JsonProperty("synopsisShort")
    private String synopsisShort;
    @JsonProperty("nationality")
    private List<CodeName> nationality = new ArrayList<>();
    @JsonProperty("genre")
    private List<CodeName> genre = new ArrayList<>();
    @JsonProperty("castMember")
    private List<CastMember> castMember = new ArrayList<>();
    @JsonProperty("statistics")
    private Statistics statistics;
    private List<MediaBasic> media = new ArrayList<>();
    @JsonProperty("poster")
    private Artwork poster;
    @JsonProperty("release")
    private Release release;
    @JsonProperty("hasDVD")
    private boolean dvd;
    @JsonProperty("castingShort")
    private CastingShort castingShort;
    @JsonProperty("news")
    private List<News> news;
    @JsonProperty("link")
    private List<Link> links;
    @JsonProperty("tag")
    private List<CodeName> tags;
    @JsonProperty("helpfulPositiveReview")
    private List<Review> helpfulPositiveReview;
    @JsonProperty("helpfulNegativeReview")
    private List<Review> helpfulNegativeReview;
    @JsonProperty("feature")
    private List<News> features;
    @JsonProperty("trivia")
    private List<Trivia> trivia;
    @JsonProperty("hasBroadcast")
    private boolean hasBroadcast;
    private Broadcast nextBroadcast;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getSynopsisShort() {
        return synopsisShort;
    }

    public void setSynopsisShort(String synopsisShort) {
        this.synopsisShort = synopsisShort;
    }

    public List<CodeName> getNationality() {
        return nationality;
    }

    public void setNationality(List<CodeName> nationality) {
        this.nationality = nationality;
    }

    public List<CodeName> getGenre() {
        return genre;
    }

    public void setGenre(List<CodeName> genre) {
        this.genre = genre;
    }

    public List<CastMember> getCastMember() {
        return castMember;
    }

    public void setCastMember(List<CastMember> castMember) {
        this.castMember = castMember;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
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
        @JsonSubTypes.Type(value = MediaVideo.class, name = "video")
    })
    @JsonSetter("media")
    public void setMedia(List<MediaBasic> media) {
        this.media = media;
    }

    public Artwork getPoster() {
        return poster;
    }

    public void setPoster(Artwork poster) {
        this.poster = poster;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public boolean isDvd() {
        return dvd;
    }

    public void setDvd(boolean dvd) {
        this.dvd = dvd;
    }

    public CastingShort getCastingShort() {
        return castingShort;
    }

    public void setCastingShort(CastingShort castingShort) {
        this.castingShort = castingShort;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<CodeName> getTags() {
        return tags;
    }

    public void setTags(List<CodeName> tags) {
        this.tags = tags;
    }

    public List<Review> getHelpfulPositiveReview() {
        return helpfulPositiveReview;
    }

    public void setHelpfulPositiveReview(List<Review> helpfulPositiveReview) {
        this.helpfulPositiveReview = helpfulPositiveReview;
    }

    public List<Review> getHelpfulNegativeReview() {
        return helpfulNegativeReview;
    }

    public void setHelpfulNegativeReview(List<Review> helpfulNegativeReview) {
        this.helpfulNegativeReview = helpfulNegativeReview;
    }

    public List<News> getFeatures() {
        return features;
    }

    public void setFeatures(List<News> features) {
        this.features = features;
    }

    public List<Trivia> getTrivia() {
        return trivia;
    }

    public void setTrivia(List<Trivia> trivia) {
        this.trivia = trivia;
    }

    public boolean isBroadcast() {
        return hasBroadcast;
    }

    public void setHasBroadcast(boolean hasBroadcast) {
        this.hasBroadcast = hasBroadcast;
    }

    public Broadcast getNextBroadcast() {
        return nextBroadcast;
    }

    @JsonSetter("nextBroadcast")
    public void setNextBroadcast(NextBroadcast nextBroadcast) {
        this.nextBroadcast = nextBroadcast.getBroadcast();
    }

}
