package com.bridgelabz.addressbookmanagementsystem;
import com.bridgelabz.addressbookmanagementsystem.csvoperations.CSVReader;
import com.bridgelabz.addressbookmanagementsystem.csvoperations.CSVWriter;

/**
 * AddressBookMain Class
 */
public class Main {
    private static final String CSV_FILE_PATH = "data/sumit.csv";
    public static void main(String[] args) {
        String[] data = {"Sumit", "Jangid", "Nagar", "Jaipur", "Rajasthan", "302021", "1234567890", "sumit@gmail.com" };
        // Write to CSV
        CSVWriter.writeCSV(CSV_FILE_PATH, data);
        CSVReader.readCSV(CSV_FILE_PATH);
    }
}