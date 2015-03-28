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
import java.util.List;

public class FormatList extends AbstractJsonUnknownHandleMapping {

    @JsonProperty("productionFormat")
    private List<CodeName> productionFormat;
    @JsonProperty("projectionFormat")
    private List<CodeName> projectionFormat;
    @JsonProperty("soundFormat")
    private List<CodeName> soundFormat;

    public List<CodeName> getProductionFormat() {
        return productionFormat;
    }

    public void setProductionFormat(List<CodeName> productionFormat) {
        this.productionFormat = productionFormat;
    }

    public List<CodeName> getProjectionFormat() {
        return projectionFormat;
    }

    public void setProjectionFormat(List<CodeName> projectionFormat) {
        this.projectionFormat = projectionFormat;
    }

    public List<CodeName> getSoundFormat() {
        return soundFormat;
    }

    public void setSoundFormat(List<CodeName> soundFormat) {
        this.soundFormat = soundFormat;
    }

}
