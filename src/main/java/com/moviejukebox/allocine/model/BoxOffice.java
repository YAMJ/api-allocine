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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class BoxOffice extends AbstractJsonMapping {

    private static final long serialVersionUID = 100L;

    @JsonProperty("type")
    private CodeName type;
    @JsonProperty("country")
    private CodeName country;
    private String periodStart;
    private String periodEnd;
    @JsonProperty("week")
    private int week;
    @JsonProperty("admissionCount")
    private Long admissionCount;
    @JsonProperty("admissionCountTotal")
    private Long admissionCountTotal;
    @JsonProperty("copyCount")
    private int copyCount;
    @JsonProperty("gross")
    private Long gross;
    @JsonProperty("grossTotal")
    private Long grossTotal;
    @JsonProperty("currency")
    private CodeName currency;

    public CodeName getType() {
        return type;
    }

    public void setType(CodeName type) {
        this.type = type;
    }

    public CodeName getCountry() {
        return country;
    }

    public void setCountry(CodeName country) {
        this.country = country;
    }

    public String getPeriodStart() {
        return periodStart;
    }

    public String getPeriodEnd() {
        return periodEnd;
    }

    @JsonSetter("period")
    public void setPeriod(AllocineDate allocineDate) {
        this.periodStart = allocineDate.getDateStart();
        this.periodEnd = allocineDate.getDateEnd();
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public Long getAdmissionCount() {
        return admissionCount;
    }

    public void setAdmissionCount(Long admissionCount) {
        this.admissionCount = admissionCount;
    }

    public Long getAdmissionCountTotal() {
        return admissionCountTotal;
    }

    public void setAdmissionCountTotal(Long admissionCountTotal) {
        this.admissionCountTotal = admissionCountTotal;
    }

    public int getCopyCount() {
        return copyCount;
    }

    public void setCopyCount(int copyCount) {
        this.copyCount = copyCount;
    }

    public Long getGross() {
        return gross;
    }

    public void setGross(Long gross) {
        this.gross = gross;
    }

    public Long getGrossTotal() {
        return grossTotal;
    }

    public void setGrossTotal(Long grossTotal) {
        this.grossTotal = grossTotal;
    }

    public CodeName getCurrency() {
        return currency;
    }

    public void setCurrency(CodeName currency) {
        this.currency = currency;
    }

}
