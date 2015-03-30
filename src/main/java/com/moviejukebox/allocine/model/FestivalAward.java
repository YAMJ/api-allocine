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
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

@JsonRootName("festivalAward")
public class FestivalAward extends AbstractJsonMapping {

    private static final long serialVersionUID = 100L;

    @JsonProperty("parentFestival")
    private CodeName parentFestival;
    @JsonProperty("parentEdition")
    private CodeName parentEdition;
    @JsonProperty("name")
    private String name;
    @JsonProperty("code")
    private int code;
    @JsonProperty("awardType")
    private CodeName awardType;
    @JsonProperty("entities")
    private Entity entities;
    @JsonProperty("sectionType")
    private CodeName sectionType;

    public CodeName getParentFestival() {
        return parentFestival;
    }

    public void setParentFestival(CodeName parentFestival) {
        this.parentFestival = parentFestival;
    }

    public CodeName getParentEdition() {
        return parentEdition;
    }

    public void setParentEdition(CodeName parentEdition) {
        this.parentEdition = parentEdition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFestival() {
        return parentFestival == null ? null : parentFestival.getName();
    }

    public int getYear() {
        if (parentEdition != null && StringUtils.isNumeric(parentEdition.getName())) {
            return NumberUtils.toInt(parentEdition.getName(), -1);
        }
        return -1;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CodeName getAwardType() {
        return awardType;
    }

    public void setAwardType(CodeName awardType) {
        this.awardType = awardType;
    }

    public Entity getEntities() {
        return entities;
    }

    public void setEntities(Entity entities) {
        this.entities = entities;
    }

    public CodeName getSectionType() {
        return sectionType;
    }

    public void setSectionType(CodeName sectionType) {
        this.sectionType = sectionType;
    }
}
