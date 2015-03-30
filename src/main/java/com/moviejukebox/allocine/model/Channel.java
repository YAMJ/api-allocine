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

@JsonRootName("channel")
@JsonIgnoreProperties(value = {"trailerEmbed"})
public class Channel extends AbstractJsonMapping {

    private static final long serialVersionUID = 100L;

    @JsonProperty("code")
    private int code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private CodeName country;
    private String logo;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CodeName getCountry() {
        return country;
    }

    public void setCountry(CodeName country) {
        this.country = country;
    }

    public String getLogo() {
        return logo;
    }

    @JsonSetter("logo")
    public void setLogo(Link link) {
        this.logo = link.getHref();
    }

}
