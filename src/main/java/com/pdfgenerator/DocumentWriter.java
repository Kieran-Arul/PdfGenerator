package com.pdfgenerator;

public interface DocumentWriter {

    void writeText(String text);
    void addParagraphOfText(String text);
    void parseTextFileThenWrite(String textFilePath, CommandMapping mapping);
    void setTextFont(TextFont textFont);
    void setTextSize(TextSize textSize);
    void closeDocument();

}
