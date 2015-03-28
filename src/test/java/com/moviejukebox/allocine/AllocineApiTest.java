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
package com.moviejukebox.allocine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.moviejukebox.allocine.model.*;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllocineApiTest {

    private static final Logger LOG = LoggerFactory.getLogger(AllocineApiTest.class);
    private static final String PARTNER_KEY = "100043982026";
    private static final String SECRET_KEY = "29d185d98c984a359e6e6f26a0474269";

    private static AllocineApi api;
    private static HttpClient httpClient;

    @BeforeClass
    public static void beforeClass() throws AllocineException {
        // This must be the first statement in the beforeClass method
        TestLogger.Configure();
        httpClient = HttpClients.createDefault();
        api = new AllocineApi(PARTNER_KEY, SECRET_KEY, httpClient);
    }

//    @Test
    public void testAccentSearch() throws Exception {
        LOG.info("testAccentSearch");
        final Search search = api.searchMovies("Mémoires de nos pères");
        boolean found = false;
        for (Movie movie : search.getMovies()) {
            if (movie.getCode() == 60580) {
                found = true;
                break;
            }
        }
        assertTrue("No movies found!", search.getMovies().size() > 0);
        assertTrue("Movie not found in search", found);
    }

//    @Test
    public void testSearchMovies() throws Exception {
        LOG.info("testSearchMovieInfos");
        final Search search = api.searchMovies("avatar");
        assertEquals(10, search.getMovies().size());
    }

    @Test
    public void testSearchTvseriesInfos() throws Exception {
        LOG.info("testSearchTvseriesInfos");
        final Search search = api.searchTvSeries("glee");
        assertEquals(1, search.getTvSeries().size());
    }

//    @Test
    public void testSearchPersons() throws Exception {
        LOG.info("testSearchPersons");
        final Search search = api.searchPersons("Sam Worthington");
        assertEquals(1, search.getPersons().size());
    }

//    @Test
    public void testGetMovieInfos() throws Exception {
        LOG.info("testGetMovieInfos");
        final MovieInfos movieInfos = api.getMovieInfos("61282");
        // 61282 - Avatar
        // 45322 - Underworld
        // 25722 - SHAFT

        assertEquals(61282, movieInfos.getCode());
        assertEquals(9720, movieInfos.getRuntime());
        assertEquals("Avatar", movieInfos.getTitle());
        assertEquals("Avatar", movieInfos.getOriginalTitle());
        assertEquals(2009, movieInfos.getProductionYear());
        assertEquals("2009-12-16", movieInfos.getReleaseDate());
        assertNotNull(movieInfos.getSynopsis());
        assertEquals("Twentieth Century Fox France", movieInfos.getDistributor());
        assertEquals(2, movieInfos.getGenres().size());
        assertEquals(1, movieInfos.getNationalities().size());
        assertEquals(1, movieInfos.getDirectors().size());
        assertEquals(1, movieInfos.getWriters().size());
        assertEquals(42, movieInfos.getActors().size());
        assertEquals(85, movieInfos.getUserRating());

        for (FestivalAward award : movieInfos.getFestivalAwards()) {
            LOG.trace("Award: {}", award.getName());
        }
    }

//    @Test
    public void testGetTvSeriesInfos() throws Exception {
        LOG.info("testGetTvSeriesInfos");
        final TvSeriesInfos tvseriesInfos = api.getTvSeriesInfos("132");

        assertEquals(132, tvseriesInfos.getCode());
        assertEquals("Mon oncle Charlie", tvseriesInfos.getTitle());
        assertEquals("Two and a Half Men", tvseriesInfos.getOriginalTitle());
        assertEquals(2003, tvseriesInfos.getYearStart());
        assertEquals(0, tvseriesInfos.getYearEnd());
        assertEquals("CBS", tvseriesInfos.getOriginalChannel());
        assertEquals("La vie d'un riche célibataire est bouleversée lorsque son frère divorcé et son neveu de 10 ans débarquent dans sa propriété de Malibu. Malgré leurs différences, les deux frères décident de co-habiter pour offrir un foyer au jeune Jake.", tvseriesInfos.getSynopsis());
        assertEquals(1, tvseriesInfos.getGenres().size());
        assertEquals(1, tvseriesInfos.getNationalities().size());
        //assertEquals(1, tvseriesInfos.getDirectors().size());
        //assertTrue(tvseriesInfos.getWriters().size() >= 12);
        assertTrue(tvseriesInfos.getActors().size() >= 5);
        assertEquals(70, tvseriesInfos.getUserRating());
        assertEquals(12, tvseriesInfos.getSeasonCount());
        assertEquals(12, tvseriesInfos.getSeasonList().size());

        for (FestivalAward award : tvseriesInfos.getFestivalAwards()) {
            LOG.trace("Award: {}", award.getName());
        }
    }

    @Test
    public void testGetTvSeasonInfos() throws Exception {
        LOG.info("testGetTvSeasonInfos");
        final TvSeasonInfos tvseasonInfos = api.getTvSeasonInfos(22242);
        assertEquals(22242, tvseasonInfos.getCode());
        assertEquals(4, tvseasonInfos.getSeasonNumber());
        assertEquals(2014, tvseasonInfos.getYearStart());
        assertEquals(2014, tvseasonInfos.getYearEnd());
        assertEquals(10, tvseasonInfos.getEpisodeList().size());

        for (MoviePerson person : tvseasonInfos.getDirectors()) {
            LOG.trace("Director: {}", person.getName());
        }
        for (MoviePerson person : tvseasonInfos.getWriters()) {
            LOG.info("Writer: {}", person.getName());
        }
        for (MoviePerson person : tvseasonInfos.getActors()) {
            LOG.trace("Actor ({}): {}", person.isLeadActor(), person.getName());
        }
    }

    @Test
    public void testCertification() throws Exception {
        LOG.info("testCertification");
        MovieInfos movieInfos = api.getMovieInfos("21189"); // Fight club, should be a "16"
        assertEquals("Incorrect certificate", "16", movieInfos.getCertification());
        movieInfos = api.getMovieInfos("61282"); // Avatar - has no certificate, should be "All"
        assertEquals("Incorrect certificate", "All", movieInfos.getCertification());
    }

    @Test
    public void testGetPersonInfos() throws Exception {
        LOG.info("testGetPersonInfos");
        final PersonInfos personInfos = api.getPersonInfos("8504");
        assertEquals(8504, personInfos.getCode());
        assertEquals("1954-12-28", personInfos.getBirthDate());
        assertEquals("Denzel", personInfos.getFirstName());
        assertEquals("Washington", personInfos.getLastName());

        for (FestivalAward award : personInfos.getFestivalAwards()) {
            LOG.trace("Award: {}", award.getName());
        }
    }

//    @Test
    public void testGetPersonFilmography() throws Exception {
        LOG.info("testGetPersonFilmography");
        final FilmographyInfos filmographyInfos = api.getPersonFilmography("41339");
        for (Participance p : filmographyInfos.getParticipances()) {
            if (p.isTvShow()) {
                LOG.trace("TV SHOW ({}) {}: {} - {}", p.getCode(), p.getTitle(), p.getYearStart(), p.getYearEnd());
            } else {
                LOG.trace("MOVIE ({}) {}: {} ({})", p.getCode(), p.getTitle(), p.getYear(), p.getReleaseDate());
            }
        }
    }

//    @Test
    public void testGetEpisodeInfos() throws Exception {
        LOG.info("testGetEpisodeInfos");
        final EpisodeInfos episodeInfos = api.getEpisodeInfos("493491");
        assertEquals(493491, episodeInfos.getCode());

        for (MoviePerson person : episodeInfos.getDirectors()) {
            LOG.trace("Director: {}", person.getName());
        }
        for (MoviePerson person : episodeInfos.getWriters()) {
            LOG.trace("Writer: {}", person.getName());
        }
        for (MoviePerson person : episodeInfos.getActors()) {
            LOG.trace("Actor ({}): {}", person.isLeadActor(), person.getName());
        }
    }
}
