package com.pdfgenerator.writer;

import com.pdfgenerator.formatter.TextFont;
import com.pdfgenerator.formatter.TextSize;
import com.pdfgenerator.parser.mapping.CommandMapping;

public interface DocumentWriter {

    void writeText(String text);
    void addParagraphOfText(String text);
    void parseTextFileThenWrite(String textFilePath, CommandMapping mapping);
    void setTextFont(TextFont textFont);
    void setTextSize(TextSize textSize);
    void closeDocument();

}
