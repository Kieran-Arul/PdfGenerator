package com.pdfgenerator;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.FileNotFoundException;

public class PdfDocumentWriter implements DocumentWriter {

    private final String filePath;
    private final TextFileParser textFileParser;
    private final Document document;
    private TextSize currentTextSize;
    private TextFont currentTextFont;

    public PdfDocumentWriter(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        this.textFileParser = new TextFileParser();
        this.document = new Document(new PdfDocument(new PdfWriter(this.filePath)));
        this.currentTextSize = TextSize.NORMAL;
        this.currentTextFont = TextFont.REGULAR;
    }

    @Override
    public void writeText(String text) {

    }

    @Override
    public void addParagraphOfText(String text) {

    }

    @Override
    public void parseTextFileThenWrite(String textFilePath, CommandMapping mapping) {

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
    public void closeDocument() {
        this.document.close();
    }

}
