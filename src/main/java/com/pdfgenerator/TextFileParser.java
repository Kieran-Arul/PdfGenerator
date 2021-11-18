package com.pdfgenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileParser {

    private String filePath;

    public TextFileParser() {
        this.filePath = null;
    }

    public TextFileParser(String filePath) {
        this.filePath = filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<String> parseFile() {

        List<String> results = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                results.add(line);
            }

        } catch (FileNotFoundException e) {

            System.out.println("Unable to find text file to parse. Please set file path correctly");
            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return results;

    }

}
