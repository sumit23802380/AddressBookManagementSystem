package com.bridgelabz.addressbookmanagementsystem.csvoperations;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/**
 * @desc : CSVWriter class
 */
public class CSVWriter {
    /**
     * @desc : Method to write the data into csvfile path
     * @param : csvFilePath - file in which to write the data
     * @param : data - the data we have to write in the csvfile
     */
    public static void writeCSV(String csvFilePath, String[] data) {
        try {
            Writer writer = new FileWriter(csvFilePath, true); // 'true' for appending to an existing file
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            csvPrinter.printRecord(Arrays.asList(data));
            csvPrinter.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
