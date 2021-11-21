package com.pdfgenerator;

import com.pdfgenerator.parser.mapping.CustomCommandMapping;
import com.pdfgenerator.writer.PdfDocumentWriter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        PdfDocumentWriter writer = new PdfDocumentWriter("./testing.pdf");
        CustomCommandMapping commandMapping = new CustomCommandMapping();
        writer.parseTextFileThenWrite("./file.txt", commandMapping);
        writer.closeDocument();

    }

}
