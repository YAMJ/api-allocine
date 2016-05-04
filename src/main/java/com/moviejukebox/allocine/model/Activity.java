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

import com.fasterxml.jackson.annotation.JsonRootName;
import com.moviejukebox.allocine.model.enumeration.Job;
import java.util.HashMap;
import java.util.Map;

@JsonRootName("activity")
public class Activity extends CodeName {

    private static final long serialVersionUID = 100L;
    // Actor codes
    private static final int ACTOR_CODE = 8001;
    // Director codes
    private static final int DIRECTOR_CODE = 8002;
    // Writer codes
    private static final int WRITER_CODE = 8004;
    private static final int SCRIPT_CODE = 8043;
    private static final int AUTEUR_CODE = 8105;
    // Producer codes
    private static final int PRODUCER_CODE = 8029;
    private static final int DELEGATE_PRODUCER_CODE = 8061;
    private static final int EXECUTIVE_PRODUCER_CODE = 8062;
    private static final int COPRODUCER_CODE = 8063;
    private static final int ASSOCIATE_PRODUCER_CODE = 8064;
    // Camera codes
    private static final int CAMERA_CODE = 8037;
    // Art codes
    private static final int CHEF_DECORATEUR_CODE = 8059;
    
    private Job job = Job.UNKNOWN;

    private static final Map<Integer, Job> JOB_LIST = new HashMap<>();

    static {
        // Actor codes
        JOB_LIST.put(ACTOR_CODE, Job.ACTOR);
        // Director codes
        JOB_LIST.put(DIRECTOR_CODE, Job.DIRECTOR);
        // Writer codes
        JOB_LIST.put(WRITER_CODE, Job.WRITER);
        JOB_LIST.put(SCRIPT_CODE, Job.WRITER);
        JOB_LIST.put(AUTEUR_CODE, Job.WRITER);
        // Producer codes
        JOB_LIST.put(PRODUCER_CODE, Job.PRODUCER);
        JOB_LIST.put(DELEGATE_PRODUCER_CODE, Job.PRODUCER);
        JOB_LIST.put(EXECUTIVE_PRODUCER_CODE, Job.PRODUCER);
        JOB_LIST.put(COPRODUCER_CODE, Job.PRODUCER);
        JOB_LIST.put(ASSOCIATE_PRODUCER_CODE, Job.PRODUCER);
        // Camera codes
        JOB_LIST.put(CAMERA_CODE, Job.CAMERA);
        // Art codes
        JOB_LIST.put(CHEF_DECORATEUR_CODE, Job.ART);
    }

    @Override
    public void setCode(int code) {
        super.setCode(code);

        this.job = JOB_LIST.get(code);
        if (this.job == null) {
            this.job = Job.UNKNOWN;
        }
    }

    private boolean hasJob(Job job) {
        return this.job == job;
    }

    public boolean isActor() {
        return hasJob(Job.ACTOR);
    }

    public boolean isDirector() {
        return hasJob(Job.DIRECTOR);
    }

    public boolean isWriter() {
        return hasJob(Job.WRITER);
    }

    public boolean isProducer() {
        return hasJob(Job.PRODUCER);
    }

    public boolean isCamera() {
        return hasJob(Job.CAMERA);
    }

    public boolean isArt() {
        return hasJob(Job.ART);
    }

    public boolean isUnknown() {
        return hasJob(Job.UNKNOWN);
    }
}
