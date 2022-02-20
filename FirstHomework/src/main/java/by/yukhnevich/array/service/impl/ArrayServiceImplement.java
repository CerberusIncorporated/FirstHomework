package by.yukhnevich.array.service.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.service.ArrayService;
import by.yukhnevich.array.validation.ArrayValidation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayServiceImplement implements ArrayService {
    private static final Logger LOGGER = LogManager.getLogger(ArrayServiceImplement.class);

    @Override
    public int findMinNumber(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }

        int min = array.getArray()[0];
        for (int temp : array.getArray()) {
            if (temp < min) {
                min = temp;
            }
        }
        LOGGER.log(Level.INFO, String.format("Min value in array %s is %d", array.toString(), min));
        return min;
    }

    @Override
    public int findMaxNumber(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }

        int max = array.getArray()[0];
        for (int temp : array.getArray()) {
            if (temp > max) {
                max = temp;
            }
        }

        LOGGER.log(Level.INFO, String.format("Max value in array %s is %d", array.toString(), max));
        return max;
    }

    @Override
    public long findSumOfArray(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }

        int sum = 0;
        for (int i = 0; i < array.getArray().length; i++) {
            sum += array.getArray()[i];
        }
        LOGGER.log(Level.INFO, String.format("Sum of array %s is %d", array.toString(), sum));
        return sum;
    }

    @Override
    public int findPositiveNumbers(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
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
    public int findAverageNumber(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }

        int sum = (int) findSumOfArray(array);
        int average = sum / array.getArray().length;

        LOGGER.log(Level.INFO, String.format("Average values in array %s is %d", array.toString(), average));
        return average;
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
