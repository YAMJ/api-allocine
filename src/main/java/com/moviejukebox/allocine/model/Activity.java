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
import com.moviejukebox.allocine.model.enumeration.Job;

@JsonRootName("activity")
public class Activity extends AbstractJsonMapping {

    private static final long serialVersionUID = 1739586583915230L;
    // Actor codes
    private static final int ACTOR_CODE = 8001;
    // Director codes
    private static final int DIRECTOR_CODE = 8002;
    // Producer codes
    private static final int PRODUCER_CODE = 8029;
    private static final int DELEGATE_PRODUCER_CODE = 8061;
    private static final int EXECUTIVE_PRODUCER_CODE = 8062;
    private static final int COPRODUCER_CODE = 8063;
    private static final int ASSOCIATE_PRODUCER_CODE = 8064;
    // Writer codes
    private static final int WRITER_CODE = 8004;
    private static final int SCRIPT_CODE = 8043;
    // Camera codes
    private static final int CAMERA_CODE = 8037;

    @JsonProperty("code")
    private int code;
    @JsonProperty("$")
    private String name;
    private Job job = Job.UNKNOWN;

    public long getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;

        // Populate the job with the correct value
        switch (code) {
            // List all actor codes
            case ACTOR_CODE:
                this.job = Job.ACTOR;
                break;
            // List all director codes
            case DIRECTOR_CODE:
                this.job = Job.DIRECTOR;
                break;
            // List all producer codes
            case PRODUCER_CODE:
            case DELEGATE_PRODUCER_CODE:
            case EXECUTIVE_PRODUCER_CODE:
            case COPRODUCER_CODE:
            case ASSOCIATE_PRODUCER_CODE:
                this.job = Job.PRODUCER;
                break;
            // List all writer codes
            case WRITER_CODE:
            case SCRIPT_CODE:
                this.job = Job.WRITER;
                break;
            // List all camera codes
            case CAMERA_CODE:
                this.job = Job.CAMERA;
                break;
            // The job is unknown
            default:
                this.job = Job.UNKNOWN;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActor() {
        return job == Job.ACTOR;
    }

    public boolean isDirector() {
        return job == Job.DIRECTOR;
    }

    public boolean isWriter() {
        return job == Job.WRITER;
    }

    public boolean isCamera() {
        return job == Job.CAMERA;
    }

    public boolean isProducer() {
        return job == Job.PRODUCER;
    }

    public boolean isKnownActivity() {
        return job != Job.UNKNOWN;
    }
}
