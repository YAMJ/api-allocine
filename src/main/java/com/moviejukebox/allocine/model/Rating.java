package com.moviejukebox.allocine.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating extends AbstractJsonMapping {

    @JsonProperty("note")
    private float note;
    @JsonProperty("$")
    private long count;

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}
