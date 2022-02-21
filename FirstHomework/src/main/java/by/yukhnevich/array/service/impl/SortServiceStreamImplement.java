package by.yukhnevich.array.service.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.service.SortService;
import by.yukhnevich.array.validation.ArrayValidation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SortServiceStreamImplement implements SortService {
    private static final Logger LOGGER = LogManager.getLogger(SortServiceStreamImplement.class);


    @Override
    public void bubbleSort(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }
        int[] tempArray = Arrays.stream(array.getArray())
                .sorted().toArray();
        LOGGER.log(Level.INFO, String.format("Stream sort completed %s", array.toString()));
        array.setArray(tempArray);
    }

    @Override
    public void insertSort(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }
        int[] tempArray = Arrays.stream(array.getArray())
                .sorted().toArray();
        LOGGER.log(Level.INFO, String.format("Stream sort completed %s", array.toString()));
        array.setArray(tempArray);
    }

    @Override
    public void selectionSort(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }
        int[] tempArray = Arrays.stream(array.getArray())
                .sorted().toArray();
        LOGGER.log(Level.INFO, String.format("Stream sort completed %s", array.toString()));
        array.setArray(tempArray);
    }
}
