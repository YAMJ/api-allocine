package com.moviejukebox.allocine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class TypeValue extends AbstractJsonMapping {

    @JsonProperty("type")
    private String type;
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    @JsonSetter("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonSetter("$")
    public void setDollarValue(String value) {
        this.value = value;
    }

}
