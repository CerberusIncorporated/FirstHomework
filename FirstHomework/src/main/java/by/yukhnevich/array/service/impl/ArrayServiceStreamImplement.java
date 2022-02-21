package by.yukhnevich.array.service.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.service.ArrayService;
import by.yukhnevich.array.validation.ArrayValidation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayServiceStreamImplement implements ArrayService {
    private static final Logger LOGGER = LogManager.getLogger(SortServiceStreamImplement.class);

    @Override
    public int findMinNumber(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }
        int min = Arrays.stream(array.getArray())
                .min()
                .orElseThrow(CustomArrayException::new);
        LOGGER.log(Level.INFO, String.format("[Stream]Min value in array %s is %d", array.toString(), min));
        return min;
    }

    @Override
    public int findMaxNumber(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }
        int max = Arrays.stream(array.getArray())
                .max()
                .orElseThrow(CustomArrayException::new);
        LOGGER.log(Level.INFO, String.format("[Stream]Max value in array %s is %d", array.toString(), max));
        return max;
    }

    @Override
    public long findSumOfArray(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }
        long sum = Arrays.stream(array.getArray()).sum();
        LOGGER.log(Level.INFO, String.format("[Stream]Sum values in array %s is %d", array.toString(), sum));
        return sum;
    }

    @Override
    public int findPositiveNumbers(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }
        int count = (int) Arrays.stream(array.getArray())
                .filter(s -> s >= 0)
                .count();
        LOGGER.log(Level.INFO, String.format("[Stream]Positive numbers in array %s is %d", array.toString(), count));
        return count;
    }

    @Override
    public int findNegativeNumbers(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }
        int count = (int) Arrays.stream(array.getArray())
                .filter(s -> s < 0)
                .count();
        LOGGER.log(Level.INFO, String.format("[Stream]Negative numbers in array %s is %d", array.toString(), count));
        return count;
    }

    @Override
    public double findAverageNumber(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }
        double average = Arrays.stream(array.getArray())
                .average()
                .orElseThrow(CustomArrayException::new);
        LOGGER.log(Level.INFO, String.format("[Stream]Average numbers in array %s is %d", array.toString(), average));
        return average;
    }

    @Override
    public void replaceNegativeNumbers(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }
        int num = -1;
        int[] newArray = IntStream.of(array.getArray())
                .map(element -> element < 0 ? num : element)
                .toArray();
        CustomArray resultArray = new CustomArray(newArray.length);
        array.setArray(newArray);
        LOGGER.log(Level.INFO, String.format("[Stream]All negative numbers is replaced %s", array.toString()));
    }
}
