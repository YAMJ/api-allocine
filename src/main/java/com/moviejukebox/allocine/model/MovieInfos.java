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
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the Movie Search bean for the api.allocine.fr search
 *
 * @author Yves.Blusseau
 */
public class MovieInfos extends AbstractBaseInfos {

    private static final long serialVersionUID = -7592718256970353295L;
    private static final Pattern AGE_REGEXP = Pattern.compile("\\s(\\d{1,2})\\san");

    @JsonProperty("movie")
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public boolean isValid() {
        if (movie == null) {
            return false;
        }
        return movie.getCode() > 0;
    }

    public boolean isNotValid() {
        return !this.isValid();
    }

    public int getCode() {
        return this.getCode(movie);
    }

    public String getTitle() {
        return this.getTitle(movie);
    }

    public String getOriginalTitle() {
        return this.getOriginalTitle(movie);
    }

    public int getProductionYear() {
        if (movie == null) {
            return -1;
        }
        return movie.getProductionYear();
    }

    public int getRuntime() {
        if (movie == null) {
            return -1;
        }
        return movie.getRuntime();
    }

    public String getReleaseDate() {
        return this.getReleaseDate(movie);
    }

    public String getReleaseState() {
        return this.getReleaseState(movie);
    }

    public String getSynopsis() {
        return this.getSynopsis(movie);
    }

    public String getSynopsisShort() {
        return this.getSynopsisShort(movie);
    }

    public int getUserRating() {
        return this.getUserRating(movie);
    }

    public int getPressRating() {
        return this.getPressRating(movie);
    }

    public String getCertification() {
        // Default value
        String certification = "All";
        if (movie != null && movie.getMovieCertificate() != null) {
            Certificate certificate = movie.getMovieCertificate().getCertificate();
            if (certificate != null) {
                Matcher match = AGE_REGEXP.matcher(certificate.getName());
                if (match.find()) {
                    certification = match.group(1);
                }
            }
        }
        return certification;
    }

    public Set<String> getGenres() {
        return this.getGenres(movie);
    }

    public Set<String> getNationalities() {
        return this.getNationalities(movie);
    }

    public String getDistributor() {
        if (movie == null) {
            return null;
        }
        if (movie.getRelease() != null && movie.getRelease().getDistributor() != null) {
            return movie.getRelease().getDistributor().getName();
        }
        return null;
    }

    public Set<MoviePerson> getActors() {
        return this.getActors(movie);
    }

    public Set<MoviePerson> getDirectors() {
        return this.getDirectors(movie);
    }

    public Set<MoviePerson> getWriters() {
        return this.getWriters(movie);
    }
    
    public Set<MoviePerson> getCamera() {
        return this.getCamera(movie);
    }

    public Set<MoviePerson> getProducers() {
        return this.getProducers(movie);
    }
    
    public Set<String> getPosterUrls() {
        return this.getPosterUrls(movie);
    }
}
