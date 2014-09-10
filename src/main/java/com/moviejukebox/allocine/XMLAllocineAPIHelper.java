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

import com.moviejukebox.allocine.jaxb.ObjectFactory;
import com.moviejukebox.allocine.tools.WebBrowser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HTTP;
import org.yamj.api.common.http.CommonHttpClient;
import org.yamj.api.common.http.UserAgentSelector;

/**
 * Implementation for XML format
 *
 * @author Yves Blusseau
 */
public final class XMLAllocineAPIHelper extends AbstractAllocineAPI {

    private static final JAXBContext JAXB_CONTEXT = initContext();

    /**
     * Constructor.
     */
    public XMLAllocineAPIHelper(String partnerKey, String secretKey) {
        super(partnerKey, secretKey, "xml");
    }

    /**
     * Constructor.
     */
    public XMLAllocineAPIHelper(String partnerKey, String secretKey, CommonHttpClient httpClient) {
        super(partnerKey, secretKey, "xml", httpClient);
    }

    private static JAXBContext initContext() {
        try {
            return JAXBContext.newInstance("com.moviejukebox.allocine.jaxb");
        } catch (JAXBException error) {
            throw new Error("XMLAllocineAPIHelper: Got error during initialization", error);
        }
    }

    private static Unmarshaller createAllocineUnmarshaller() throws JAXBException {
        Unmarshaller unmarshaller = JAXB_CONTEXT.createUnmarshaller();
        // Use our own ObjectFactory so we can add behaviors in our classes
        unmarshaller.setProperty("com.sun.xml.bind.ObjectFactory", new ObjectFactory());
        return unmarshaller;
    }

    private InputStream createHttpClientInputStream(URL url) throws IOException {
        HttpGet httpGet;
        try {
            httpGet = new HttpGet(url.toURI());
        } catch (URISyntaxException e) {
            throw new IOException(e.getMessage(), e);
        }
        
        httpGet.addHeader("accept", "application/json");
        httpGet.setHeader(HTTP.USER_AGENT, UserAgentSelector.randomUserAgent());
        return this.httpClient.requestResource(httpGet).getContent();
    }
    
    @Override
    public Search searchMovieInfos(String query) throws IOException, JAXBException, XMLStreamException {
        Unmarshaller unmarshaller = createAllocineUnmarshaller();

        URLConnection connection = null;
        InputStream inputStream = null;
        try {
            URL url = urlSearchMovieInfos(query);

            if (this.httpClient == null) {
                connection = WebBrowser.openProxiedConnection(url);
                inputStream = connection.getInputStream();
            } else {
                inputStream = this.createHttpClientInputStream(url);
            }

            return validSearchElement(unmarshaller.unmarshal(inputStream));
        } finally {
            close(connection, inputStream);
        }
    }

    @Override
    public Search searchTvseriesInfos(String query) throws IOException, JAXBException, XMLStreamException {
        Unmarshaller unmarshaller = createAllocineUnmarshaller();

        URLConnection connection = null;
        InputStream inputStream = null;
        try {
            URL url = urlSearchTvseriesInfos(query);

            if (this.httpClient == null) {
                connection = WebBrowser.openProxiedConnection(url);
                inputStream = connection.getInputStream();
            } else {
                inputStream = this.createHttpClientInputStream(url);
            }

            return validSearchElement(unmarshaller.unmarshal(inputStream));
        } finally {
            close(connection, inputStream);
        }
    }

    @Override
    public MovieInfos getMovieInfos(String allocineId) throws IOException, JAXBException, XMLStreamException {
        Unmarshaller unmarshaller = createAllocineUnmarshaller();

        URLConnection connection = null;
        InputStream inputStream = null;
        try {
            URL url = urlGetMovieInfos(allocineId);

            if (this.httpClient == null) {
                connection = WebBrowser.openProxiedConnection(url);
                inputStream = connection.getInputStream();
            } else {
                inputStream = this.createHttpClientInputStream(url);
            }

            return validMovieElement(unmarshaller.unmarshal(inputStream));
        } finally {
            close(connection, inputStream);
        }
    }

    protected static MovieInfos getMovieInfos(File file) throws IOException, JAXBException {
        Unmarshaller unmarshaller = createAllocineUnmarshaller();
        return validMovieElement(unmarshaller.unmarshal(file));
    }

    @Override
    public TvSeriesInfos getTvSeriesInfos(String allocineId) throws IOException, JAXBException, XMLStreamException {
        Unmarshaller unmarshaller = createAllocineUnmarshaller();

        URLConnection connection = null;
        InputStream inputStream = null;
        try {
            URL url = urlGetTvSeriesInfos(allocineId);

            if (this.httpClient == null) {
                connection = WebBrowser.openProxiedConnection(url);
                inputStream = connection.getInputStream();
            } else {
                inputStream = this.createHttpClientInputStream(url);
            }

            return validTvSeriesElement(unmarshaller.unmarshal(inputStream));
        } finally {
            close(connection, inputStream);
        }
    }

    @Override
    public TvSeasonInfos getTvSeasonInfos(Integer seasonCode) throws IOException, JAXBException, XMLStreamException {
        Unmarshaller unmarshaller = createAllocineUnmarshaller();

        URLConnection connection = null;
        InputStream inputStream = null;
        try {
            URL url = urlGetTvSeasonInfos(seasonCode);

            if (this.httpClient == null) {
                connection = WebBrowser.openProxiedConnection(url);
                inputStream = connection.getInputStream();
            } else {
                inputStream = this.createHttpClientInputStream(url);
            }

            return validTvSeasonElement(unmarshaller.unmarshal(inputStream));
        } finally {
            close(connection, inputStream);
        }
    }

    private static Search validSearchElement(Object rootElement) {
        if (rootElement.getClass() == Search.class) {
            return (Search) rootElement;
        }
        // Error
        return new Search();
    }

    private static MovieInfos validMovieElement(Object rootElement) {
        if (rootElement.getClass() == MovieInfos.class) {
            return (MovieInfos) rootElement;
        }
        // Error
        return new MovieInfos();
    }

    private static TvSeriesInfos validTvSeriesElement(Object rootElement) {
        if (rootElement.getClass() == TvSeriesInfos.class) {
            return (TvSeriesInfos) rootElement;
        }
        // Error
        return new TvSeriesInfos();
    }

    private static TvSeasonInfos validTvSeasonElement(Object rootElement) {
        if (rootElement.getClass() == TvSeasonInfos.class) {
            return (TvSeasonInfos) rootElement;
        }
        // Error
        return new TvSeasonInfos();
    }
}
