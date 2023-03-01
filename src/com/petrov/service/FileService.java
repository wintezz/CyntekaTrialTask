package com.petrov.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public static List<String> fileToList(File input) {

        List<String> stringList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        try (FileReader fileReader = new FileReader(input)) {
            int c;
            while ((c = fileReader.read()) != -1) {
                if ((char) c == '\r' || (char) c == '\n' || (char) c == '\uFEFF') {

                    if (!sb.isEmpty()) {
                        stringList.add(sb.toString().toLowerCase());
                    }
                    sb = new StringBuilder();

                } else {
                    sb.append((char) c);
                }
            }
            stringList.add(sb.toString().toLowerCase());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public static void listToFile(File output, List<String> stringList) {

        try (FileWriter fileWriter = new FileWriter(output)) {
            for (String str : stringList) {
                fileWriter.write(str);
                fileWriter.write("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
