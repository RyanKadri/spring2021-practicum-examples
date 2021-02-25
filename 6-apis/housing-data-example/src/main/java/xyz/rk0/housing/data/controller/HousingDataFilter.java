package xyz.rk0.housing.data.controller;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HousingDataFilter {

    /* Note: The cleanest way to code this filter is probably in 3 separate phases. First filter by zipCode, then by startDate, then by endDate
     * checking that each one has been provided. This method is a little lazier than the most efficient way of doing it but boy howdy is it short.
     * Could be optimized by factoring out the null checks. They don't need to happen for every record.
     **/
    public List<HousingRecord> filterData(List<HousingRecord> allRecords, String zipCode, LocalDate startDate, LocalDate endDate) {
        return allRecords.stream()
            .filter(record -> zipCode == null || record.getZipCode().equals(zipCode))
            .filter(record -> startDate == null || !record.getSaleDate().isBefore(startDate))
            .filter(record -> endDate == null || !record.getSaleDate().isAfter(endDate))
            .collect(Collectors.toList());
    }

    /* Here's a way to do a similar thing with looping
     */
    public List<HousingRecord> filterDataImperative(List<HousingRecord> allRecords, String zipCode, LocalDate startDate, LocalDate endDate) {
        List<HousingRecord> filteredRecords = new ArrayList<>();
        for(HousingRecord record : allRecords) {
            boolean keep = true;
            if(!record.getZipCode().equals(zipCode)) {
                keep = false;
            } else if (startDate != null && record.getSaleDate().isBefore(startDate)) {
                keep = false;
            } else if (endDate != null && record.getSaleDate().isAfter(endDate)) {
                keep = false;
            }

            if(keep) {
                filteredRecords.add(record);
            }
        }
        return filteredRecords;
    }

}
