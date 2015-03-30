package com.moviejukebox.allocine.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CodeNameOriginal extends CodeName {

    @JsonProperty("original")
    private boolean original;

    public boolean isOriginal() {
        return original;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

}
