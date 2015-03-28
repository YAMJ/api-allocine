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
import java.util.ArrayList;
import java.util.List;

@JsonRootName("movie")
public class Movie extends AbstractBaseMapping {

    private static final long serialVersionUID = -5673435740544636661L;

    @JsonProperty("productionYear")
    private int productionYear;
    @JsonProperty("runtime")
    private int runtime;
    @JsonProperty("trailer")
    private Trailer trailer;
    @JsonProperty("trailerEmbed")
    private String trailerEmbed;
    @JsonProperty("movieCertificate")
    private MovieCertificate movieCertificate;
    @JsonProperty("festivalAward")
    private List<FestivalAward> festivalAwards = new ArrayList<>();
    @JsonProperty("movieType")
    private MovieType movieType;
    @JsonProperty("color")
    private String color;
    @JsonProperty("language")
    private List<Language> languages = new ArrayList<>();
    @JsonProperty("budget")
    private String budget;
    @JsonProperty("hasVOD")
    private boolean vod;
    @JsonProperty("hasBluRay")
    private boolean bluray;
    @JsonProperty("hasDVD")
    private boolean dvd;
    @JsonProperty("hasShowtime")
    private boolean showtime;
    @JsonProperty("dvdReleaseDate")
    private String dvdReleaseDate;
    @JsonProperty("bluRayReleaseDate")
    private String bluRayReleaseDate;
    @JsonProperty("keywords")
    private String keywords;
    @JsonProperty("castingShort")
    private CastingShort castingShort;
    @JsonProperty("news")
    private List<News> news;
    @JsonProperty("link")
    private List<Link> links;
    @JsonProperty("feature")
    private List<News> features;
    @JsonProperty("trivia")
    private List<Trivia> trivia;
    @JsonProperty("tag")
    private List<Tag> tags;
    @JsonProperty("boxOffice")
    private List<BoxOffice> boxOffice;
    @JsonProperty("helpfulPositiveReview")
    private List<Review> helpfulPositiveReview;
    @JsonProperty("helpfulNegativeReview")
    private List<Review> helpfulNegativeReview;

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public MovieCertificate getMovieCertificate() {
        return movieCertificate;
    }

    public void setMovieCertificate(MovieCertificate movieCertificate) {
        this.movieCertificate = movieCertificate;
    }

    public List<FestivalAward> getFestivalAwards() {
        return festivalAwards;
    }

    public void setFestivalAwards(List<FestivalAward> festivalAwards) {
        this.festivalAwards = festivalAwards;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(CodeName color) {
        this.color = color.getName();
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public boolean isVod() {
        return vod;
    }

    public void setVod(boolean vod) {
        this.vod = vod;
    }

    public boolean isBluray() {
        return bluray;
    }

    public void setBluray(boolean bluray) {
        this.bluray = bluray;
    }

    public boolean isDvd() {
        return dvd;
    }

    public void setDvd(boolean dvd) {
        this.dvd = dvd;
    }

    public boolean isShowtime() {
        return showtime;
    }

    public void setShowtime(boolean showtime) {
        this.showtime = showtime;
    }

    public String getDvdReleaseDate() {
        return dvdReleaseDate;
    }

    public void setDvdReleaseDate(String dvdReleaseDate) {
        this.dvdReleaseDate = dvdReleaseDate;
    }

    public String getBluRayReleaseDate() {
        return bluRayReleaseDate;
    }

    public void setBluRayReleaseDate(String bluRayReleaseDate) {
        this.bluRayReleaseDate = bluRayReleaseDate;
    }

    public String getTrailerEmbed() {
        return trailerEmbed;
    }

    public void setTrailerEmbed(String trailerEmbed) {
        this.trailerEmbed = trailerEmbed;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<BoxOffice> getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(List<BoxOffice> boxOffice) {
        this.boxOffice = boxOffice;
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

}
