package xyz.rk0.housing.data.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class DataLoaderTest {

    // This is more of an integration test than a unit test since it relies on an external data file.
    // There are ways to make this a pure unit test but it may be more trouble than it's worth
    @Test
    public void readsData() throws IOException {
        // Having a made-for-testing CSV file helps our tests be independent of real data changing
        DataLoader loader = new DataLoader("./src/test/testRecords.csv");
        List<HousingRecord> records = loader.readCsv();

        Assertions.assertEquals(2, records.size());
        Assertions.assertEquals(68212, records.get(1).getPrice());
        Assertions.assertEquals("95823", records.get(1).getZipCode());
    }

}
