package com.pdfgenerator.writer;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.pdfgenerator.formatter.TextFont;
import com.pdfgenerator.formatter.TextFormat;
import com.pdfgenerator.formatter.TextLayout;
import com.pdfgenerator.formatter.TextSize;
import com.pdfgenerator.parser.TextFileParser;
import com.pdfgenerator.parser.mapping.CommandMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PdfDocumentWriter implements DocumentWriter {

    private final String filePath;
    private final TextFileParser textFileParser;
    private final Document document;
    private Paragraph currentParagraph;
    private final WriterSettings writerSettings;

    public PdfDocumentWriter(String filePath) throws IOException {
        this.filePath = filePath;
        this.textFileParser = new TextFileParser();
        this.document = new Document(new PdfDocument(new PdfWriter(this.filePath)));
        this.currentParagraph = null;
        this.writerSettings = new WriterSettings();
    }

    // Method that appends text to existing paragraph
    @Override
    public void writeText(String text) {

        // If a user attempts to write text before creating a paragraph
        if (this.currentParagraph == null) {
            this.currentParagraph = new Paragraph().setMarginLeft(20 * this.getIndentation());
        }

        PdfFont font = this.getTextFont();
        int textSize = this.getTextSize();

        Text textToAdd = new Text(text + " ").setFont(font).setFontSize(textSize);
        this.currentParagraph.add(textToAdd);

    }

    // Method that adds the current paragraph to the PDF and creates a new one
    @Override
    public void addParagraph() {

        if (this.currentParagraph != null) {
            this.document.add(this.currentParagraph);
        }

        this.currentParagraph = new Paragraph();

    }

    // Method that indents the current paragraph
    @Override
    public void indentParagraph() {
        this.currentParagraph.setMarginLeft(20 * this.getIndentation());
    }

    // Method that uses specific commands in a text file to populate a PDF
    @Override
    public void parseTextFileThenWrite(String textFilePath, CommandMapping map) throws IOException {

        List<String> commands = this.textFileParser.parseFile(textFilePath);
        Map<String, TextFormat> commandMapping = map.getMapping();

        for (String command : commands) {

            if (commandMapping.containsKey(command)) {

                TextFormat format = commandMapping.get(command);

                if (format == TextLayout.PARAGRAPH) {

                    this.addParagraph();

                } else if (format == TextLayout.INDENT) {

                    this.indentParagraph();

                } else {

                    this.adjustWriterSetting(format);

                }

            } else if (command.startsWith(".indent")) {

                this.setIndentationLevel(this.determineIndent(command));

            } else {

                this.writeText(command);

            }

        }

    }

    @Override
    public void setTextFont(TextFont textFont) throws IOException {
        this.writerSettings.setTextFont(textFont);
    }

    @Override
    public void setTextSize(TextSize textSize) {
        this.writerSettings.setTextSize(textSize);
    }

    @Override
    public void setIndentationLevel(int indentation) {
        this.writerSettings.setIndentation(indentation);
    }

    @Override
    public void closeDocument() {
        this.document.add(this.currentParagraph);
        this.document.close();
    }

    private void adjustWriterSetting(TextFormat format) throws IOException {

        if (format instanceof TextSize) {

            this.setTextSize((TextSize) format);

        } else if (format instanceof TextFont) {

            this.setTextFont((TextFont) format);

        }

    }

    // Helper method to parse a ".indent" command, extracting the magnitude of how much to change the indentation
    private int determineIndent(String indentCommand) throws NumberFormatException {

        String[] s = indentCommand.split(" ");

        return Integer.parseInt(s[1]);

    }

    private PdfFont getTextFont() {
        return this.writerSettings.getTextFont();
    }

    private int getTextSize() {
        return this.writerSettings.getTextSize();
    }

    private int getIndentation() {
        return this.writerSettings.getIndentation();
    }

}
