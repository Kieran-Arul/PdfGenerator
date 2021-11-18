package com.pdfgenerator;

public interface DocumentWriter {

    void setTargetDocument(String filePath);
    void writeText(String text);
    void setTextFont(TextFont textFont);
    void setTextSize(TextSize textSize);
    void addParagraphOfText(String text);
    void closeDocument();

}
