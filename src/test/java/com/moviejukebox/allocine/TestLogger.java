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
package com.moviejukebox.allocine;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {

    private static final Logger LOG = LoggerFactory.getLogger(TestLogger.class);
    private static final String CRLF = "\n";

    private TestLogger() {
        throw new UnsupportedOperationException("Class can not be instantiated");
    }

    /**
     * Configure the logger with a simple in-memory file for the required log level
     *
     * @param level The logging level required
     * @return True if successful
     */
    public static boolean configure(String level) {
        StringBuilder config = new StringBuilder("handlers = java.util.logging.ConsoleHandler\n");
        config.append(".level = ").append(level).append(CRLF);
        config.append("java.util.logging.ConsoleHandler.level = ").append(level).append(CRLF);
        // Only works with Java 7 or later
        config.append("java.util.logging.SimpleFormatter.format = [%1$tH:%1$tM:%1$tS %4$6s] %2$s - %5$s %6$s%n").append(CRLF);
        // Exclude http logging
        config.append("sun.net.www.protocol.http.HttpURLConnection.level = OFF").append(CRLF);
        config.append("org.apache.http.level = SEVERE").append(CRLF);

        try (InputStream ins = new ByteArrayInputStream(config.toString().getBytes())) {
            LogManager.getLogManager().readConfiguration(ins);
        } catch (IOException ex) {
            LOG.warn("Failed to configure log manager due to an IO problem", ex);
            return Boolean.FALSE;
        }
        LOG.debug("Logger initialized to '{}' level", level);
        return Boolean.TRUE;
    }

    /**
     * Set the logging level to "ALL"
     *
     * @return True if successful
     */
    public static boolean configure() {
        return configure("ALL");
    }
}
