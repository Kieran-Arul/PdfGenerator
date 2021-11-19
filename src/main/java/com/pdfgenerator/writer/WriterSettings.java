package com.pdfgenerator.writer;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.pdfgenerator.formatter.TextFont;
import com.pdfgenerator.formatter.TextSize;

import java.io.IOException;

public class WriterSettings {

    private PdfFont textFont;
    private int textSize;
    private int indentation;

    public WriterSettings() throws IOException {
        this.textFont = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        this.textSize = 12;
        this.indentation = 0;
    }

    public PdfFont getTextFont() {
        return this.textFont;
    }

    // Design question:
    // Should this method be dealing with the TextFont to PdfFont mapping or should that be dealt with in the
    // PDFDocumentWriter class, with this method below taking an PdfFont as an argument instead?
    // My intuition says that this class should not
    public void setTextFont(TextFont font) throws IOException {

        switch (font) {

            case BOLD:
                this.textFont = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
                break;

            case ITALIC:
                this.textFont = PdfFontFactory.createFont(StandardFonts.TIMES_ITALIC);
                break;

            default:
                this.textFont = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
                break;

        }

    }

    public int getTextSize() {
        return this.textSize;
    }

    // Design question:
    // Should this method be dealing with the TextSize to int mapping or should that be dealt with in the
    // PDFDocumentWriter class, with this method below taking an int as an argument instead?
    public void setTextSize(TextSize size) {

        if (size == TextSize.LARGE) {

            this.textSize = 20;

        } else {

            this.textSize = 12;

        }

    }

    public int getIndentation() {
        return this.indentation;
    }

    public void setIndentation(int indentation) {
        this.indentation = indentation;
    }

}
