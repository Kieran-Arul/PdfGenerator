package com.pdfgenerator.parser.mapping;

import com.pdfgenerator.formatter.TextFont;
import com.pdfgenerator.formatter.TextFormat;
import com.pdfgenerator.formatter.TextLayout;
import com.pdfgenerator.formatter.TextSize;

import java.util.Collections;
import java.util.HashMap;

public class CustomCommandMapping implements CommandMapping {

    private HashMap<String, TextFormat> mapping;

    public CustomCommandMapping() {

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
