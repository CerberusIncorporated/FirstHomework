package by.yukhnevich.array.service.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.service.ArrayService;
import by.yukhnevich.array.validation.ArrayValidation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class ArrayServiceImplement implements ArrayService {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public OptionalInt findMinNumber(CustomArray array) {
        if (!ArrayValidation.validateArray(array)) {
            return OptionalInt.empty();
        }

        int min = array.getArray()[0];
        for (int temp : array.getArray()) {
            if (temp < min) {
                min = temp;
            }
        }
        LOGGER.log(Level.INFO, String.format("Min value in array %s is %d", array.toString(), min));
        return OptionalInt.of(min);
    }

    @Override
    public OptionalInt findMaxNumber(CustomArray array) {
        if (!ArrayValidation.validateArray(array)) {
            return OptionalInt.empty();
        }

        int max = array.getArray()[0];
        for (int temp : array.getArray()) {
            if (temp > max) {
                max = temp;
            }
        }

        LOGGER.log(Level.INFO, String.format("Max value in array %s is %d", array.toString(), max));
        return OptionalInt.of(max);
    }

    @Override
    public OptionalLong findSumOfArray(CustomArray array) {
        if (!ArrayValidation.validateArray(array)) {
            return OptionalLong.empty();
        }

        int sum = 0;
        for (int i = 0; i < array.getArray().length; i++) {
            sum += array.getArray()[i];
        }
        LOGGER.log(Level.INFO, String.format("Sum of array %s is %d", array.toString(), sum));
        return OptionalLong.of(sum);
    }

    @Override
    public int findPositiveNumbers(CustomArray array) {
        if (!ArrayValidation.validateArray(array)) {
            try {
                throw new CustomArrayException("Invalid input array [empty or null]");
            } catch (CustomArrayException e) {
                e.printStackTrace();
            }
        }

        int count = 0;
        for (int i = 0; i < array.getArray().length; i++) {
            if (array.getArray()[i] >= 0) {
                count++;
            }
        }
        LOGGER.log(Level.INFO, String.format("Count positive values in array %s is %d", array.toString(), count));
        return count;
    }

    @Override
    public int findNegativeNumbers(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }

        int count = 0;
        for (int i = 0; i < array.getArray().length; i++) {
            if (array.getArray()[i] < 0) {
                count++;
            }
        }
        LOGGER.log(Level.INFO, String.format("Count negative value in array %s is %d", array.toString(), count));
        return count;
    }

    @Override
    public OptionalDouble findAverageNumber(CustomArray array) {
        if (!ArrayValidation.validateArray(array)) {
            return OptionalDouble.empty();
        }

        long sum = 0;

        for (int element : array.getArray()) {
            sum += element;
        }

        double average = sum / array.getArray().length;

        LOGGER.log(Level.INFO, String.format("Average values in array %s is %d", array.toString(), average));
        return OptionalDouble.of(average);
    }

    @Override
    public void replaceNegativeNumbers(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }

        int[] tempArray = array.getArray();
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] < 0) {
                tempArray[i] = -1;
            }
        }
        array.setArray(tempArray);
        LOGGER.log(Level.INFO, String.format("All negative values in array is replaced %s", array.toString()));
    }
}
