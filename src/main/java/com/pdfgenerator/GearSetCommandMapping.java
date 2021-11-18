package com.pdfgenerator;

import java.util.Collections;
import java.util.HashMap;

public class GearSetCommandMapping implements CommandMapping {

    private HashMap<String, TextFormat> mapping;

    public GearSetCommandMapping() {

        this.mapping = new HashMap<>();

        this.mapping.put(".paragraph", TextLayout.PARAGRAPH);
        this.mapping.put(".bold", TextFont.BOLD);
        this.mapping.put(".italic", TextFont.ITALIC);
        this.mapping.put(".regular", TextFont.REGULAR);
        this.mapping.put(".large", TextSize.LARGE);
        this.mapping.put(".normal", TextSize.NORMAL);
        this.mapping.put(".fill", TextLayout.INDENT);
        this.mapping.put(".nofill", TextLayout.INDENT);

    }

    @Override
    public HashMap<String, TextFormat> getMapping() {
        return (HashMap<String, TextFormat>) Collections.unmodifiableMap(this.mapping);
    }

    @Override
    public void setMapping(HashMap<String, TextFormat> mapping) {
        this.mapping = mapping;
    }

}
