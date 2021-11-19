package com.pdfgenerator.writer;

import com.itextpdf.kernel.font.PdfFont;
import com.pdfgenerator.formatter.TextFont;
import com.pdfgenerator.formatter.TextSize;
import com.pdfgenerator.parser.mapping.CommandMapping;

import java.io.IOException;

public interface DocumentWriter {

    void writeText(String text);
    void addParagraphOfText(String text);
    void parseTextFileThenWrite(String textFilePath, CommandMapping mapping) throws IOException;
    PdfFont getTextFont() throws IOException;
    int getTextSize();
    int getIndentation();
    void setTextFont(TextFont textFont) throws IOException;
    void setTextSize(TextSize textSize);
    void setIndentation(int indentation);
    void closeDocument();

}
