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
package com.moviejukebox.allocine;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moviejukebox.allocine.model.AbstractJsonUnknownHandleMapping;
import com.moviejukebox.allocine.model.Person;
import com.moviejukebox.allocine.tools.HtmlTools;

/**
 * This is the Person Search bean for the api.allocine.fr search
 *
 * @author modmax
 */
public class PersonInfos extends AbstractJsonUnknownHandleMapping {

    private static final long serialVersionUID = 7745674601738810957L;

    @JsonProperty("person")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isValid() {
        if (person == null) {
            return false;
        }
        return (person.getCode() > 0);
    }

    public boolean isNotValid() {
        return !this.isValid();
    }

    public int getCode() {
        if (person == null) {
            return -1;
        }
        return person.getCode();
    }

    public int getGender() {
        if (person == null) {
            return -1;
        }
        return person.getGender();
    }

    public String getBiographyShort() {
        if (person == null) {
            return null;
        }
        return HtmlTools.removeLineFeeds(person.getBiographyShort());
    }

    public String getBiography() {
        if (person == null) {
            return null;
        }
        return HtmlTools.removeLineFeeds(person.getBiography());
    }

    public String getBirthDate() {
        if (person == null) {
            return null;
        }
        return person.getBirthDate();
    }

    public String getBirthPlace() {
        if (person == null) {
            return null;
        }
        return person.getBirthPlace();
    }

    public String getPhotoURL() {
        if (person == null) {
            return null;
        }
        if (person.getPicture() == null) {
            return null;
        }
        return person.getPicture().getHref();
    }
}