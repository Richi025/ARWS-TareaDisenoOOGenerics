package edu.escuelaing.arsw.ASE.app;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains main methods to run the project, as well as a method to read the files containing the data to be analyzed.
 */
public class StatisticalCalculator {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java -jar target/TareaDisenoOOGenerics-1.0-SNAPSHOT.jar (rutaArchivo)");
            return;
        }
        
        String filePath = args[0];
        List<LinkedList<Double>> columns = StatisticalCalculator.readNumbersFromFile(filePath);
        if (columns == null) {
            System.out.println("Error reading the file.");
            return;
        }

        for (int i = 0; i < columns.size(); i++) {
            LinkedList<Double> column = columns.get(i);
            double mean = StatisticsOperations.calculate(column, numbers -> StatisticsOperations.calculateMean(numbers));
            double standardDeviation = StatisticsOperations.calculate(column, numbers -> StatisticsOperations.calculateStandardDeviation(numbers, mean));

            System.out.println("Column " + (i + 1) + ":");
            System.out.println("Mean: " + mean);
            System.out.println("Standard Deviation: " + standardDeviation);
            System.out.println();
        }
    }
    /**
     * Reads numbers from a file and organizes them into columns.
     * Each line in the file represents a row of numbers separated by whitespace.
     * Each column of numbers is stored in a LinkedList.
     *
     * @param filePath the path to the file containing the numbers.
     * @return a list of LinkedLists, each representing a column of numbers.
     */
    public static List<LinkedList<Double>> readNumbersFromFile(String filePath) {
        List<LinkedList<Double>> columns = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\s+");
                for (int i = 0; i < values.length; i++) {
                    if (columns.size() <= i) {
                        columns.add(new LinkedList<>());
                    }
                    try {
                        double number = Double.parseDouble(values[i]);
                        columns.get(i).add(number);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number in file: " + values[i]);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
        return columns;
    }
}