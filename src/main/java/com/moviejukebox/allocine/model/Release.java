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

@JsonRootName("release")
public class Release extends AbstractJsonMapping {

    private static final long serialVersionUID = 100L;

    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("country")
    private CodeName country;
    @JsonProperty("distributor")
    private CodeName distributor;
    @JsonProperty("releaseState")
    private CodeName releaseState;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public CodeName getCountry() {
        return country;
    }

    public void setCountry(CodeName country) {
        this.country = country;
    }

    public CodeName getDistributor() {
        return distributor;
    }

    public void setDistributor(CodeName distributor) {
        this.distributor = distributor;
    }

    public CodeName getReleaseState() {
        return releaseState;
    }

    public void setReleaseState(CodeName releaseState) {
        this.releaseState = releaseState;
    }
}
