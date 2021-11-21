package com.pdfgenerator.writer;

import com.itextpdf.kernel.font.PdfFont;
import com.pdfgenerator.formatter.TextFont;
import com.pdfgenerator.formatter.TextSize;
import com.pdfgenerator.parser.mapping.CommandMapping;

import java.io.IOException;

public interface DocumentWriter {

    void writeText(String text);
    void addParagraph();
    void indentParagraph();
    void parseTextFileThenWrite(String textFilePath, CommandMapping mapping) throws IOException;
    void setTextFont(TextFont textFont) throws IOException;
    void setTextSize(TextSize textSize);
    void setIndentationLevel(int indentation);
    void closeDocument();

}
