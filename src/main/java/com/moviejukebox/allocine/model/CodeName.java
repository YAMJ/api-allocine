package com.moviejukebox.allocine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CodeName extends AbstractJsonMapping {

    @JsonProperty("code")
    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    @JsonSetter("$")
    public void setValue(String name) {
        this.name = name;
    }

    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }

}
