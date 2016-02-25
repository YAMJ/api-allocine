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

import com.moviejukebox.allocine.tools.HtmlTools;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * This is the Person Search bean for the api.allocine.fr search
 *
 * @author modmax
 */
public class PersonInfos extends AbstractPersonInfo {

    private static final long serialVersionUID = 100L;

    public String getFullName() {
        if (getPerson() == null || getPerson().getPersonName() == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        if (getPerson().getPersonName().getGiven() != null) {
            sb.append(getPerson().getPersonName().getGiven());
            sb.append(" ");
        }
        if (getPerson().getPersonName().getFamily() != null) {
            sb.append(getPerson().getPersonName().getFamily());
        }
        return StringUtils.trimToNull(sb.toString());
    }

    public String getFirstName() {
        if (getPerson() == null || getPerson().getPersonName() == null) {
            return null;
        }
        return getPerson().getPersonName().getGiven();
    }

    public String getLastName() {
        if (getPerson() == null || getPerson().getPersonName() == null) {
            return null;
        }
        return getPerson().getPersonName().getFamily();
    }

    public int getGender() {
        return getPerson() == null ? -1 : getPerson().getGender();
    }

    public String getBiographyShort() {
        return getPerson() == null ? null : HtmlTools.removeLineFeeds(getPerson().getBiographyShort());
    }

    public String getBiography() {
        return getPerson() == null ? null : HtmlTools.removeLineFeeds(getPerson().getBiography());
    }

    public String getBirthDate() {
        return getPerson() == null ? null : getPerson().getBirthDate();
    }

    public String getBirthPlace() {
        return getPerson() == null ? null : getPerson().getBirthPlace();
    }

    public String getRealName() {
        return getPerson() == null ? null : getPerson().getRealName();
    }

    public String getDeathDate() {
        return getPerson() == null ? null : getPerson().getDeathDate();
    }

    public String getDeathPlace() {
        return getPerson() == null ? null : getPerson().getDeathPlace();
    }

    public String getPhotoURL() {
        if (getPerson() == null) {
            return null;
        }
        if (getPerson().getPicture() == null) {
            return null;
        }
        return getPerson().getPicture().getHref();
    }

    public List<FestivalAward> getFestivalAwards() {
        return getPerson() == null ? null : getPerson().getFestivalAwards();
    }
}
