package com.bonus71.data.test;

import com.bonus71.data.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;



public class ResourceReaderTest {

    @Test
    void testReadCsv() throws IOException {
        ResourceReader resourceReader = new ResourceReader();
        List<List<String>> results = resourceReader.readCSVAsList("Test_CSV.csv");
        System.out.println(results);
    }

    @Test
    void testReadActualCsv() throws IOException {
        ResourceReader resourceReader = new ResourceReader();
        List<List<String>> results = resourceReader.readCSVAsList("kratproesodaexoda.csv");

        for (List<String> result : results) {
            System.out.println(result);
        }
    }
}
