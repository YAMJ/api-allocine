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

@JsonRootName("festivalAward")
public class FestivalAward extends AbstractJsonUnknownHandleMapping {

    private static final long serialVersionUID = 6122348929992079547L;

    @JsonProperty("parentFestival")
    private ParentFestival parentFestival;
    @JsonProperty("parentEdition")
    private ParentEdition parentEdition;
    @JsonProperty("name")
    private String name;

    public ParentFestival getParentFestival() {
        return parentFestival;
    }

    public void setParentFestival(ParentFestival parentFestival) {
        this.parentFestival = parentFestival;
    }

    public ParentEdition getParentEdition() {
        return parentEdition;
    }

    public void setParentEdition(ParentEdition parentEdition) {
        this.parentEdition = parentEdition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFestival() {
        return (parentFestival == null ? null : parentFestival.getName());
    }
    
    public int getYear() {
        if (parentEdition != null && StringUtils.isNumeric(parentEdition.getName())) {
            return Integer.parseInt(parentEdition.getName());
        }
        return -1;
    }
}
