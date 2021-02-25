package xyz.rk0.housing.data.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HousingDataFilterTest {

    @Test
    public void testZipCodeFilter() {
        HousingDataFilter dataFilter = new HousingDataFilter();
        List<HousingRecord> sampleRecords = List.of(
            new HousingRecord(1, 100, "12345", LocalDate.parse("2020-01-01", DateTimeFormatter.ISO_LOCAL_DATE)),
            new HousingRecord(2, 200, "22345", LocalDate.parse("2020-01-01", DateTimeFormatter.ISO_LOCAL_DATE)),
            new HousingRecord(3, 300, "32345", LocalDate.parse("2020-01-01", DateTimeFormatter.ISO_LOCAL_DATE))
        );
        List<HousingRecord> filteredList = dataFilter.filterData(sampleRecords, "22345", null, null);
        Assertions.assertEquals(1, filteredList.size());
        Assertions.assertEquals(200, filteredList.get(0).getSquareFeet());
    }

    @Test
    public void testStartDateFilter() {
        HousingDataFilter dataFilter = new HousingDataFilter();
        List<HousingRecord> sampleRecords = List.of(
            new HousingRecord(1, 100, "12345", LocalDate.parse("2020-01-01", DateTimeFormatter.ISO_LOCAL_DATE)),
            new HousingRecord(2, 200, "22345", LocalDate.parse("2020-01-02", DateTimeFormatter.ISO_LOCAL_DATE)),
            new HousingRecord(3, 300, "32345", LocalDate.parse("2020-01-03", DateTimeFormatter.ISO_LOCAL_DATE))
        );
        List<HousingRecord> filteredList = dataFilter.filterData(sampleRecords, null, LocalDate.parse("2020-01-02", DateTimeFormatter.ISO_LOCAL_DATE), null);
        Assertions.assertEquals(2, filteredList.size());
        Assertions.assertEquals(sampleRecords.get(1), filteredList.get(0));
        Assertions.assertEquals(sampleRecords.get(2), filteredList.get(1));
    }

    @Test
    public void filterMultiple() {
        HousingDataFilter dataFilter = new HousingDataFilter();
        List<HousingRecord> sampleRecords = List.of(
            new HousingRecord(1, 100, "12345", LocalDate.parse("2020-01-01", DateTimeFormatter.ISO_LOCAL_DATE)),
            new HousingRecord(2, 200, "12345", LocalDate.parse("2020-01-02", DateTimeFormatter.ISO_LOCAL_DATE)),
            new HousingRecord(3, 300, "32345", LocalDate.parse("2020-01-03", DateTimeFormatter.ISO_LOCAL_DATE))
        );

        LocalDate startDate = LocalDate.parse("2020-01-02", DateTimeFormatter.ISO_LOCAL_DATE);
        List<HousingRecord> filteredList = dataFilter.filterData(sampleRecords, "12345", startDate, null);

        Assertions.assertEquals(1, filteredList.size());
        Assertions.assertEquals(sampleRecords.get(1), filteredList.get(0));
    }
}
