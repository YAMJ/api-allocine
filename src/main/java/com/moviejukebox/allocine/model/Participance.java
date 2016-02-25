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
package com.moviejukebox.allocine.model;

public class Participance {

    private final boolean tvShow;
    private long code = -1;

    // according to person
    private String role;
    private boolean actor = false;
    private boolean director = false;
    private boolean writer = false;
    private boolean camera = false;
    private boolean producer = false;

    // according to movie
    private int year = -1;
    // according to series
    private int yearStart = -1;
    private int yearEnd = -1;
    // accoring to season
    private long seasonCode = -1;
    private int seasonNumber = -1;

    private String releaseDate;
    private String releaseCountry;
    private String title;
    private String originalTitle;
    private String synopsisShort;

    public Participance(boolean tvShow) {
        this.tvShow = tvShow;
    }

    public boolean isTvShow() {
        return tvShow;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActor() {
        return actor;
    }

    public void setActor(boolean actor) {
        this.actor = actor;
    }

    public boolean isDirector() {
        return director;
    }

    public void setDirector(boolean director) {
        this.director = director;
    }

    public boolean isWriter() {
        return writer;
    }

    public void setWriter(boolean writer) {
        this.writer = writer;
    }

    public boolean isCamera() {
        return camera;
    }

    public void setCamera(boolean camera) {
        this.camera = camera;
    }

    public boolean isProducer() {
        return producer;
    }

    public void setProducer(boolean producer) {
        this.producer = producer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        }
    }

    public int getYearStart() {
        return yearStart;
    }

    public void setYearStart(int yearStart) {
        if (yearStart > 0) {
            this.yearStart = yearStart;
        }
    }

    public int getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(int yearEnd) {
        if (yearEnd > 0) {
            this.yearEnd = yearEnd;
        }
    }

    public long getSeasonCode() {
        return seasonCode;
    }

    public void setSeasonCode(long seasonCode) {
        this.seasonCode = seasonCode;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseCountry() {
        return releaseCountry;
    }

    public void setReleaseCountry(String releaseCountry) {
        this.releaseCountry = releaseCountry;
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

    public String getSynopsisShort() {
        return synopsisShort;
    }

    public void setSynopsisShort(String synopsisShort) {
        this.synopsisShort = synopsisShort;
    }
}
