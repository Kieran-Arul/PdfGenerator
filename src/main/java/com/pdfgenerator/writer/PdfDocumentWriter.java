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

// Writer class
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

    @Override
    public void writeText(String text) {

        if (this.currentParagraph == null) {
            this.currentParagraph = new Paragraph().setMarginLeft(10 * this.getIndentation());
        }

        PdfFont font = this.getTextFont();
        int textSize = this.getTextSize();

        Text textToAdd = new Text(text).setFont(font).setFontSize(textSize);
        this.currentParagraph.add(textToAdd);

    }

    @Override
    public void addParagraphOfText(String text) {

        if (this.currentParagraph != null) {
            this.document.add(this.currentParagraph);
        }

        PdfFont font = this.getTextFont();
        int textSize = this.getTextSize();
        int indentSize = this.getIndentation();

        Text textToAdd = new Text(text).setFont(font).setFontSize(textSize);
        this.currentParagraph = new Paragraph(textToAdd).setMarginLeft(10 * indentSize);

    }

    private void adjustWriterSetting(TextFormat format) throws IOException {

        if (format instanceof TextSize) {

            this.setTextSize((TextSize) format);

        } else if (format instanceof TextFont) {

            this.setTextFont((TextFont) format);

        }

    }

    private int determineIndent(String indentCommand) {

        String[] s = indentCommand.split(" ");

        return Integer.parseInt(s[1]);

    }

    @Override
    public void parseTextFileThenWrite(String textFilePath, CommandMapping map) throws IOException {

        List<String> commands = this.textFileParser.parseFile(textFilePath);
        Map<String, TextFormat> commandMapping = map.getMapping();

        for (int i = 0; i < commands.size(); i++) {

            if (commandMapping.containsKey(commands.get(i))) {

                TextFormat format = commandMapping.get(commands.get(i));

                if (format == TextLayout.PARAGRAPH) {

                    this.addParagraphOfText(commands.get(++i));

                } else if (format == TextLayout.INDENT) {

                    this.setIndentation(this.determineIndent(commands.get(++i)));

                } else {

                    this.adjustWriterSetting(format);

                }

            } else {

                this.writeText(commands.get(i));

            }

        }

    }

    @Override
    public PdfFont getTextFont() {
        return this.writerSettings.getTextFont();
    }

    @Override
    public void setTextFont(TextFont textFont) throws IOException {
        this.writerSettings.setTextFont(textFont);
    }

    @Override
    public int getTextSize() {
        return this.writerSettings.getTextSize();
    }

    @Override
    public void setTextSize(TextSize textSize) {
        this.writerSettings.setTextSize(textSize);
    }

    @Override
    public int getIndentation() {
        return this.writerSettings.getIndentation();
    }

    @Override
    public void setIndentation(int indentation) {
        this.writerSettings.setIndentation(indentation);
    }

    @Override
    public void closeDocument() {
        this.document.close();
    }

}
