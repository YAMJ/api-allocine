package com.moviejukebox.allocine.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CodeNameShort extends CodeName {

    @JsonProperty("nameShort")
    private String nameShort;

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

}
