package com.pdfgenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileParser {

    public List<String> parseFile(String filePath) throws IOException {

        List<String> results = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                results.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Unable to find text file");
        }

        return results;

    }

}
