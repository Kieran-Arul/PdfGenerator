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

    public PdfDocumentWriter(String filePath, String textFilePath) throws FileNotFoundException {
        this.filePath = filePath;
        this.textFileParser = new TextFileParser(textFilePath);
        this.document = new Document(new PdfDocument(new PdfWriter(this.filePath)));
        this.currentTextSize = TextSize.NORMAL;
        this.currentTextFont = TextFont.REGULAR;
    }

    @Override
    public void setTargetDocument(String filePath) {

    }

    @Override
    public void writeText(String text) {

    }

    @Override
    public void setTextFont(TextFont textFont) {

    }

    @Override
    public void setTextSize(TextSize textSize) {

    }

    @Override
    public void addParagraphOfText(String text) {

    }

    @Override
    public void closeDocument() {

    }

}
