package edu.escuelaing.arsw.ASE.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * This class tests the functionality of the project.
 */
public class StatisticsOperationsTest {
    
    @Test
    public void testReadNumbersFromFileTable1() {
        String filePath = "src/main/java/edu/escuelaing/arsw/ASE/app/Table1.txt";
        try{
            List<LinkedList<Double>> columns = StatisticalCalculator.readNumbersFromFile(filePath);
        
            assertEquals(2, columns.size());
            assertEquals(10, columns.get(0).getSize());
            assertEquals(10, columns.get(1).getSize());
        }catch(Exception e){
            fail("Exception occurred" + e.getMessage());
        }

    } 

    @Test
    public void testReadNumbersFromFileEmpty() {
        String filePath = "src/main/java/edu/escuelaing/arsw/ASE/app/Empty.txt";
        try{
            List<LinkedList<Double>> columns = StatisticalCalculator.readNumbersFromFile(filePath);
            assertEquals(0, columns.size());
        }catch(Exception e){
            fail("Exception occurred" + e.getMessage());
        }
    } 

    @Test
    public void testReadNumbersFromFileMoreThanTwoColumns() {
        String filePath = "src/main/java/edu/escuelaing/arsw/ASE/app/Example2ThreeColumns.txt";
        try{
            List<LinkedList<Double>> columns = StatisticalCalculator.readNumbersFromFile(filePath);
            assertEquals(3, columns.size());
            assertEquals(10, columns.get(0).getSize());
            assertEquals(10, columns.get(1).getSize());
        }catch(Exception e){
            fail("Exception occurred" + e.getMessage());
        }
    } 

    @Test
    public void testReadNumbersFromFileBad() {
        String filePath = "src/main/java/edu/escuelaing/arsw/ASE/app/Example2ThreeColumns.txt";
        try{
            List<LinkedList<Double>> columns = StatisticalCalculator.readNumbersFromFile(filePath);
            assertEquals(3, columns.size());
        }catch(Exception e){
            fail("Exception occurred" + e.getMessage());
        }
    } 

    @Test
    public void testCalculateMeanFileTable1() {
        String filePath = "src/main/java/edu/escuelaing/arsw/ASE/app/Table1.txt";
        try{
            List<LinkedList<Double>> columns = StatisticalCalculator.readNumbersFromFile(filePath);
            double meanColumn1 = StatisticsOperations.calculateMean(columns.get(0));
            assertEquals(550.6, meanColumn1, 0.001);
            double meanColumn2 = StatisticsOperations.calculateMean(columns.get(1));
            assertEquals(60.32, meanColumn2, 0.001);
        }catch(Exception e){
            fail("Exception occurred" + e.getMessage());
        }
    }

    @Test
    public void testCalculateStandardDeviation() {
        String filePath = "src/main/java/edu/escuelaing/arsw/ASE/app/Table1.txt";
        try{
            List<LinkedList<Double>> columns = StatisticalCalculator.readNumbersFromFile(filePath);
            double meanColumn1 = StatisticsOperations.calculateMean(columns.get(0));
            double stdDev1 = StatisticsOperations.calculateStandardDeviation(columns.get(0), meanColumn1);
            assertEquals(572.02, stdDev1, 0.01);
            double meanColumn2 = StatisticsOperations.calculateMean(columns.get(0));
            double stdDev2 = StatisticsOperations.calculateStandardDeviation(columns.get(1), meanColumn2);
            assertEquals(520.53, stdDev2, 0.01);
        }catch(Exception e){
            fail("Exception occurred" + e.getMessage());
        }
        
    }

    @Test
    public void testCalculateUsingLamdaFunctions() {
        try{
            LinkedList<Double> numbers = new LinkedList<>();
            numbers.add(10.0);
            numbers.add(20.0);
            numbers.add(30.0);
            
            double mean = StatisticsOperations.calculate(numbers, nums -> StatisticsOperations.calculateMean(nums));
            double stdDev = StatisticsOperations.calculate(numbers, nums -> StatisticsOperations.calculateStandardDeviation(nums, mean));
            
            assertEquals(20.0, mean, 0.001, "The mean should be 2.0");
            assertEquals(10.0, stdDev, 0.001, "The standard deviation should be 1.0");
        }catch(Exception e){
            fail("Exception occurred" + e.getMessage());
        }
    }
}
