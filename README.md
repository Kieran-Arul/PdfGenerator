## Project Overview

- This project uses the iText 7 library to create and populate PDFs
- It includes a file parser that reads specific commands from a text file and populates a PDF accordingly

## How to Use

1\. Clone the repository

    - git clone https://github.com/Kieran-Arul/PdfGenerator

2\. cd into the project directory

    - cd PdfGenerator

3\. Open up the project in an IDE of your choice

4\. Use the pom.xml file to install the project dependencies using maven

5\. Ensure that you have a .txt file in the project root containing appropriate commands

6\. If you are trying to indent a paragraph, ensure that you in the .txt file, you create the paragraph before providing an indentation command. For example, .paragraph followed by .indent +2.

7\. Compile and run Main
