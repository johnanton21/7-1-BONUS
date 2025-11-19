package com.bonus71.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ResourceReader class.
 *
 * @author jskarpetis
 * @version 1.0
 * Created on 19/11/25.
 */
public class ResourceReader {

    public List<List<String>> readCSVAsList(String fileName) throws IOException {
        List<List<String>> data = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IOException("File not found in resources: " + fileName);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                List<String> row = new ArrayList<>(Arrays.asList(values));
                data.add(row);
            }
        }

        return data;
    }
}
