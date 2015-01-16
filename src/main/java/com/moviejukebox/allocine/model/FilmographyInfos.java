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
import com.moviejukebox.allocine.tools.HtmlTools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is the Filmography Search bean for the api.allocine.fr search
 *
 * @author modmax
 */
public class FilmographyInfos extends AbstractJsonUnknownHandleMapping {

    private static final long serialVersionUID = 1122195565082374882L;

    @JsonProperty("person")
    private Person person;

    private List<Participance> participances;
    private int responseStatusCode = 0;
    
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

    public List<Participance> getParticipances() {
        if (person == null) {
            return Collections.emptyList();
        }

        // Populate the Participances
        if (participances == null) {
            this.participances = processParticipance();
        }

        return participances;
    }

    public int getResponseStatusCode() {
        return responseStatusCode;
    }

    public void setResponseStatusCode(int responseStatusCode) {
        this.responseStatusCode = responseStatusCode;
    }
    
    /**
     * Process the participances from the main person
     *
     * @return
     */
    private List<Participance> processParticipance() {
        List<Participance> newParticipances = new ArrayList<Participance>();

        if (person.getParticipations() != null) {
            for (Participation p : person.getParticipations()) {
                if (!validParticipation(p)) {
                    continue;
                }

                Participance participance = new Participance((p.getTvSeries() != null));
                participance.setRole(p.getRole());
                participance.setActor(p.getActivity().isActor());
                participance.setDirector(p.getActivity().isDirector());
                participance.setWriter(p.getActivity().isWriter());
                participance.setCamera(p.getActivity().isCamera());
                participance.setProducer(p.getActivity().isProducer());

                if (p.getTvSeries() != null) {
                    processTV(participance, p);
                } else {
                    processMovie(participance, p);
                }

                newParticipances.add(participance);
            }
        }

        return newParticipances;
    }

    /**
     * Ensure the participation is valid
     *
     * @param p
     * @return
     */
    private boolean validParticipation(Participation p) {
        // activity must be given & known
        if (p.getActivity() == null || !p.getActivity().isKnownActivity()) {
            return false;
        }

        // We have a movie, the production year must be valid
        if (p.getMovie() != null) {
            // valid if the production year is positive
            return p.getMovie().getProductionYear() > 0;
        }

        // invalid start year
        if (p.getTvSeries() != null) {
            // valid if the year is positive
            return p.getTvSeries().getYearStart() > 0;
        }

        // The movie and TV series were null
        return false;
    }

    /**
     * Process the TV data
     *
     * @param participance
     * @param p
     */
    private void processTV(Participance participance, Participation p) {
        participance.setCode(p.getTvSeries().getCode());
        participance.setTitle(p.getTvSeries().getTitle());
        participance.setOriginalTitle(p.getTvSeries().getOriginalTitle());
        participance.setSynopsisShort(p.getTvSeries().getSynopsisShort());
        participance.setYearStart(p.getTvSeries().getYearStart());
        participance.setYearEnd(p.getTvSeries().getYearEnd());

        if ((p.getTvSeries().getSeasonList() != null) && (p.getTvSeries().getSeasonList().size() == 1)) {
            Season season = p.getTvSeries().getSeasonList().get(0);
            participance.setSeasonCode(season.getCode());
            participance.setSeasonNumber(season.getSeasonNumber());
        }

    }

    /**
     * Process the movie data
     *
     * @param participance
     * @param p
     */
    private void processMovie(Participance participance, Participation p) {
        participance.setCode(p.getMovie().getCode());
        participance.setTitle(p.getMovie().getTitle());
        participance.setOriginalTitle(p.getMovie().getOriginalTitle());
        participance.setSynopsisShort(HtmlTools.removeLineFeeds(p.getMovie().getSynopsisShort()));
        participance.setYear(p.getMovie().getProductionYear());
        if (p.getMovie().getRelease() != null) {
            participance.setReleaseDate(p.getMovie().getRelease().getReleaseDate());
            if (p.getMovie().getRelease().getReleaseState() != null) {
                participance.setReleaseState(p.getMovie().getRelease().getReleaseState().getName());
            }
        }

    }
}
