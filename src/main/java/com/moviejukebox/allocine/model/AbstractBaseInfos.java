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

import com.moviejukebox.allocine.tools.HtmlTools;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@SuppressWarnings("serial")
public abstract class AbstractBaseInfos extends AbstractJsonUnknownHandleMapping {

    // Constants
    private static final double PERCENT_OUT_OF_5 = 5.0;
    private static final int PERCENT_OUT_OF_100 = 100;

    private Set<String> genres;
    private Set<String> nationalities;
    private Set<String> posterURLS;
    private int responseStatusCode = 0;
    
    public int getResponseStatusCode() {
        return responseStatusCode;
    }

    public void setResponseStatusCode(int responseStatusCode) {
        this.responseStatusCode = responseStatusCode;
    }

    protected int getCode(final AbstractBaseMapping base) {
        return base == null ? -1 : base.getCode();
    }

    protected String getTitle(final AbstractBaseMapping base) {
        return base == null ? null : base.getTitle();
    }

    protected String getOriginalTitle(final AbstractBaseMapping base) {
        return base == null ? null : base.getOriginalTitle();
    }

    protected String getSynopsis(final AbstractBaseMapping base) {
        return base == null ? null : HtmlTools.removeLineFeeds(base.getSynopsis());
    }

    protected String getSynopsisShort(final AbstractBaseMapping base) {
        return base == null ? null : HtmlTools.removeLineFeeds(base.getSynopsisShort());
    }

    protected int getUserRating(final AbstractBaseMapping base) {
        if (base == null || base.getStatistics() == null) {
            return -1;
        }

        final double userRating = base.getStatistics().getUserRating();
        return (int) ((userRating / PERCENT_OUT_OF_5) * PERCENT_OUT_OF_100);
    }

    protected int getPressRating(final AbstractBaseMapping base) {
        if (base == null || base.getStatistics() == null) {
            return -1;
        }

        final double pressRating = base.getStatistics().getPressRating();
        return (int) ((pressRating / PERCENT_OUT_OF_5) * PERCENT_OUT_OF_100);
    }

    protected Set<String> getGenres(final AbstractBaseMapping base) {
        if (base == null) {
            return Collections.emptySet();
        }
        if (genres == null) {
            genres = new HashSet<String>();
            if (base.getGenre() != null) {
                for (Genre genre : base.getGenre()) {
                    genres.add(genre.getName());
                }
            }
        }
        return genres;
    }

    protected Set<String> getNationalities(final AbstractBaseMapping base) {
        if (base == null) {
            return Collections.emptySet();
        }
        if (nationalities == null) {
            nationalities = new HashSet<String>();
            if (base.getNationality() != null) {
                for (Nationality nationality : base.getNationality()) {
                    nationalities.add(nationality.getName());
                }
            }
        }
        return nationalities;
    }

    protected Set<MoviePerson> getActors(final AbstractBaseMapping base) {
        final Set<MoviePerson> set = new LinkedHashSet<MoviePerson>();
        if (base != null && base.getCastMember() != null) {
            for (CastMember member : base.getCastMember()) {
                if (member.isActor()) {
                    final MoviePerson person = new MoviePerson();
                    person.setCode(member.getShortPerson().getCode());
                    person.setName(member.getShortPerson().getName());
                    person.setRole(member.getRole());
                    person.setLeadActor(member.isLeadActor());
                    if (member.getPicture() != null) {
                        person.setPhotoURL(member.getPicture().getHref());
                    }
                    set.add(person);
                }
            }
        }
        return set;
    }

    protected Set<MoviePerson> getDirectors(final AbstractBaseMapping base) {
        final Set<MoviePerson> set = new LinkedHashSet<MoviePerson>();
        if (base != null && base.getCastMember() != null) {
            for (CastMember member : base.getCastMember()) {
                if (member.isDirector()) {
                    addMember(member, set);
                }
            }
        }
        return set;
    }

    protected Set<MoviePerson> getWriters(final AbstractBaseMapping base) {
        final Set<MoviePerson> set = new LinkedHashSet<MoviePerson>();
        if (base != null && base.getCastMember() != null) {
            for (CastMember member : base.getCastMember()) {
                if (member.isWriter()) {
                    addMember(member, set);
                }
            }
        }
        return set;
    }

    protected Set<MoviePerson> getCamera(final AbstractBaseMapping base) {
        final Set<MoviePerson> set = new LinkedHashSet<MoviePerson>();
        if (base != null && base.getCastMember() != null) {
            for (CastMember member : base.getCastMember()) {
                if (member.isCamera()) {
                    addMember(member, set);
                }
            }
        }
        return set;
    }

    protected Set<MoviePerson> getProducers(final AbstractBaseMapping base) {
        final Set<MoviePerson> set = new LinkedHashSet<MoviePerson>();
        if (base != null && base.getCastMember() != null) {
            for (CastMember member : base.getCastMember()) {
                if (member.isProducer()) {
                    addMember(member, set);
                }
            }
        }
        return set;
    }

    /**
     * Add an cast member to a persons list
     *
     * @param member
     * @param persons
     */
    private void addMember(final CastMember member, final Set<MoviePerson> persons) {
        final MoviePerson person = new MoviePerson();
        person.setCode(member.getShortPerson().getCode());
        person.setName(member.getShortPerson().getName());
        if (member.getPicture() != null) {
            person.setPhotoURL(member.getPicture().getHref());
        }
        persons.add(person);
    }

    private void parseMediaList(final AbstractBaseMapping base) {
        if (posterURLS == null) {
            posterURLS = new LinkedHashSet<String>();
        }

        if (base != null) {
            if (base.getPoster() != null) {
                posterURLS.add(base.getPoster().getHref());
            }
            if (base.getMedia() != null) {
                for (Medium medium : base.getMedia()) {
                    if (medium.isPoster() && medium.getThumbnail() != null) {
                        posterURLS.add(medium.getThumbnail().getHref());
                    }
                }
            }
        }
    }

    protected Set<String> getPosterUrls(final AbstractBaseMapping base) {
        if (posterURLS == null) {
            parseMediaList(base);
        }
        return posterURLS;
    }

    protected String getReleaseDate(final AbstractBaseMapping base) {
        if (base == null) {
            return null;
        }
        if (base.getRelease() == null) {
            return null;
        }
        return base.getRelease().getReleaseDate();
    }

    protected String getReleaseState(final AbstractBaseMapping base) {
        if (base == null) {
            return null;
        }
        if (base.getRelease() == null) {
            return null;
        }
        if (base.getRelease().getReleaseState() == null) {
            return null;
        }
        return base.getRelease().getReleaseState().getName();
    }
}
