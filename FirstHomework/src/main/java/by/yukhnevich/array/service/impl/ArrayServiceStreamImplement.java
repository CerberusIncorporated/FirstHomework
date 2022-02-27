package by.yukhnevich.array.service.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.service.ArrayService;
import by.yukhnevich.array.validation.ArrayValidation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;

public class ArrayServiceStreamImplement implements ArrayService {
    private static final Logger LOGGER = LogManager.getLogger(SortServiceStreamImplement.class);

    @Override
    public OptionalInt findMinNumber(CustomArray array) {
        if (!ArrayValidation.validateArray(array)) {
            return OptionalInt.empty();
        }
        int min = 0;
        try {
            min = Arrays.stream(array.getArray())
                    .min()
                    .orElseThrow(CustomArrayException::new);
        } catch (CustomArrayException e) {
            e.printStackTrace();
        }
        LOGGER.log(Level.INFO, String.format("[Stream]Min value in array %s is %d", array.toString(), min));
        return OptionalInt.of(min);
    }

    @Override
    public OptionalInt findMaxNumber(CustomArray array) {
        if (!ArrayValidation.validateArray(array)) {
            return OptionalInt.empty();
        }
        int max = 0;
        try {
            max = Arrays.stream(array.getArray())
                    .max()
                    .orElseThrow(CustomArrayException::new);
        } catch (CustomArrayException e) {
            e.printStackTrace();
        }
        LOGGER.log(Level.INFO, String.format("[Stream]Max value in array %s is %d", array.toString(), max));
        return OptionalInt.of(max);
    }

    @Override
    public OptionalLong findSumOfArray(CustomArray array) {
        if (!ArrayValidation.validateArray(array)) {
            return OptionalLong.empty();
        }
        long sum = Arrays.stream(array.getArray()).sum();
        LOGGER.log(Level.INFO, String.format("[Stream]Sum values in array %s is %d", array.toString(), sum));
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
    public OptionalDouble findAverageNumber(CustomArray array) {
        if (!ArrayValidation.validateArray(array)) {
            return OptionalDouble.empty();
        }
        double average = 0;
        try {
            average = Arrays.stream(array.getArray())
                    .average()
                    .orElseThrow(CustomArrayException::new);
        } catch (CustomArrayException e) {
            e.printStackTrace();
        }
        LOGGER.log(Level.INFO, String.format("[Stream]Average numbers in array %s ", array.toString(), average));
        return OptionalDouble.of(average);
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
