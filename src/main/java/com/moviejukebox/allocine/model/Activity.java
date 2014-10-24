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
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("activity")
public class Activity extends AbstractJsonMapping {

    private static final long serialVersionUID = 1739586583915230L;
    private static final long ACTOR_CODE                = 8001;
    private static final long DIRECTOR_CODE             = 8002;
    private static final long WRITER_CODE               = 8004;
    private static final long PRODUCER_CODE             = 8029;
    private static final long CAMERA_CODE               = 8037;
    private static final long SCRIPT_CODE               = 8043;
    private static final long DELEGATE_PRODUCER_CODE    = 8061;
    private static final long EXECUTIVE_PRODUCER_CODE   = 8062;
    private static final long COPRODUCER_CODE           = 8063;
    private static final long ASSOCIATE_PRODUCER_CODE   = 8064;
    
    @JsonProperty("code")
    private long code;
    @JsonProperty("$")
    private String name;
    
    public long getCode() {
        return code;
    }
    
    public void setCode(long code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public boolean isActor() {
        return (this.code == ACTOR_CODE); 
    }

    public boolean isDirector() {
        return (this.code == DIRECTOR_CODE);
    }

    public boolean isWriter() {
        return (this.code == WRITER_CODE || this.code == SCRIPT_CODE);
    }

    public boolean isCamera() {
        return (this.code == CAMERA_CODE);
    }

    public boolean isProducer() {
        return (this.code == PRODUCER_CODE
                        || this.code == DELEGATE_PRODUCER_CODE
                        || this.code == EXECUTIVE_PRODUCER_CODE
                        || this.code == COPRODUCER_CODE
                        || this.code == ASSOCIATE_PRODUCER_CODE);
    }
    
    public boolean isCrew() {
        return (!isActor() && !isDirector() && !isWriter() && !isCamera() && !isProducer());
    }
}
