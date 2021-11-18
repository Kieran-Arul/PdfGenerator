package com.pdfgenerator;

public enum TextLayout implements TextFormat {

    INDENT(0),
    PARAGRAPH;

    private int magnitude;

    TextLayout() {

    }

    TextLayout(int magnitude) {
        this.magnitude = magnitude;
    }

    public int getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(int magnitude) {
        this.magnitude = magnitude;
    }

}
