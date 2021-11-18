package com.pdfgenerator;

import java.util.HashMap;
import java.util.Map;

public interface CommandMapping {
    Map<String, TextFormat> getMapping();
    void setMapping(HashMap<String, TextFormat> mapping);
}
