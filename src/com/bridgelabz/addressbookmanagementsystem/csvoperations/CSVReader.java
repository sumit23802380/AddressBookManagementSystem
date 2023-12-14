package com.bridgelabz.addressbookmanagementsystem.csvoperations;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @desc : CSV File reader class
 */
public class CSVReader {
    /**
     * @desc : Reads the CSV file
     * @param : csvFilePath - csv file path to read
     */
    public static void readCSV(String csvFilePath) {
        try {
            Reader reader = new FileReader(csvFilePath);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord csvRecord : csvParser) {
                String result = getResult(csvRecord);
                System.out.println(result);
            }
            csvParser.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     * @desc : Method to get the combined result of single record
     * @param : csvRecord - single csv record
     * @return : by formatting the result string
     */
    private static String getResult(CSVRecord csvRecord) {
        String firstName = csvRecord.get(0);
        String lastName = csvRecord.get(1);
        String address = csvRecord.get(2);
        String city = csvRecord.get(3);
        String state = csvRecord.get(4);
        String zip = csvRecord.get(5);
        String phoneNumber = csvRecord.get(6);
        String email = csvRecord.get(7);
        return String.format("First Name: %s, Last Name: %s, Address: %s, City: %s, State: %s, Zip: %s, Phone Number: %s, Email: %s", firstName, lastName, address, city, state, zip, phoneNumber, email);
    }
}
