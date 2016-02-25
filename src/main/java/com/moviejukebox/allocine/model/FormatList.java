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

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class FormatList extends AbstractJsonMapping {

    private static final long serialVersionUID = 100L;

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
