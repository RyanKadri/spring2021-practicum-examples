package xyz.rk0.housing.data.controller;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader {

    private List<HousingRecord> housingData = null;

    private final String filePath;
    DataLoader(
        @Value("./real-estate-data.csv") String filePath // Passing the data file as a path lets us overwrite this in tests with a different file
    ) {
        this.filePath = filePath;
    }

    public List<HousingRecord> readCsv() throws IOException {
        if(this.housingData != null) {
            // This strategy of reading the file on the first request is a little goofy since the first user has a bad experience.
            // Another approach would be using @PostConstruct or some other mechanism to parse the file as the server starts
            return this.housingData;
        } else {
            List<HousingRecord> housingInfo = new ArrayList<>();
            Reader in = new FileReader(this.filePath);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                double price = Double.parseDouble(record.get("price"));
                double squareFeet = Double.parseDouble(record.get("sq__ft"));
                String saleDateStr = record.get("sale_date");
                String zipCode = record.get("zip");
                LocalDate saleDate = LocalDate.parse(saleDateStr, DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy"));

                HousingRecord housingRecord = new HousingRecord(price, squareFeet, zipCode, saleDate);
                housingInfo.add(housingRecord);
            }

            this.housingData = housingInfo;
            return housingInfo;
        }
    }
}
