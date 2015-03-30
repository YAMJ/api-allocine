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

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.Arrays;
import java.util.List;

@JsonRootName("castingShort")
public class CastingShort extends AbstractJsonMapping {

    private static final long serialVersionUID = 100L;

    private List<String> directors;
    private List<String> actors;
    private List<String> creators;

    private List<String> asList(String source) {
        return Arrays.asList(source.split(","));
    }

    public List<String> getDirectors() {
        return directors;
    }

    @JsonSetter("directors")
    public void setDirectors(String directors) {
        this.directors = asList(directors);
    }

    public List<String> getActors() {
        return actors;
    }

    @JsonSetter("actors")
    public void setActors(String actors) {
        this.actors = asList(actors);
    }

    public List<String> getCreators() {
        return creators;
    }

    @JsonSetter("creators")
    public void setCreators(String creators) {
        this.creators = asList(creators);
    }

}
