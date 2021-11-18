package com.pdfgenerator.writer;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import com.pdfgenerator.formatter.TextFont;
import com.pdfgenerator.formatter.TextSize;
import com.pdfgenerator.parser.TextFileParser;
import com.pdfgenerator.parser.mapping.CommandMapping;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PdfDocumentWriter implements DocumentWriter {

    private final String filePath;
    private final TextFileParser textFileParser;
    private final Document document;
    private TextSize currentTextSize;
    private TextFont currentTextFont;
    private int currentIndentation;

    public PdfDocumentWriter(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        this.textFileParser = new TextFileParser();
        this.document = new Document(new PdfDocument(new PdfWriter(this.filePath)));
        this.currentTextSize = TextSize.NORMAL;
        this.currentTextFont = TextFont.REGULAR;
        this.currentIndentation = 0;
    }

    @Override
    public void writeText(String text) {

    }

    @Override
    public void addParagraphOfText(String text) {

    }

    @Override
    public void parseTextFileThenWrite(String textFilePath, CommandMapping mapping) throws IOException {
        List<String> commands = this.textFileParser.parseFile(textFilePath);
    }

    @Override
    public void setTextFont(TextFont textFont) {
        this.currentTextFont = textFont;
    }

    @Override
    public void setTextSize(TextSize textSize) {
        this.currentTextSize = textSize;
    }

    @Override
    public void setIndentation(int currentIndentation) {
        this.currentIndentation = currentIndentation;
    }

    @Override
    public void closeDocument() {
        this.document.close();
    }

}
