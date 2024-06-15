package edu.escuelaing.arsw.ASE.app;

import java.util.function.Function;

/**
 * This class contains methods for performing statistical calculations such as standard deviation and mean.
 */
public class StatisticsOperations {


    /**
     * Calculates the mean (average) of a list of numbers.
     *
     * @param numbers a LinkedList of Double values representing the numbers.
     * @return the mean of the numbers.
     */
    public static double calculateMean(LinkedList<Double> numbers) {
        double sum = 0;
        int size = numbers.getSize();
        for (double number : numbers) {
            sum += number;
        }
        return sum / size;
    }

    /**
     * Calculates the standard deviation of a list of numbers given the mean.
     *
     * @param numbers a LinkedList of Double values representing the numbers.
     * @param mean the mean of the numbers.
     * @return the standard deviation of the numbers.
     */
    public static double calculateStandardDeviation(LinkedList<Double> numbers, double mean) {
        double sumOfSquares = 0;
        int size = numbers.getSize();
        for (double number : numbers) {
            sumOfSquares += Math.pow(number - mean, 2);
        }
        return Math.sqrt(sumOfSquares / (size - 1));
    }

    /**
     * Performs a statistical calculation on a list of numbers using a lambda function.
     *
     * @param numbers a LinkedList of Double values representing the numbers.
     * @param operation a lambda function defining the statistical operation to perform.
     * @return the result of the operation.
     */
    public static double calculate(LinkedList<Double> numbers, Function<LinkedList<Double>, Double> operation) {
        return operation.apply(numbers);
    }
}
