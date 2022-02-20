package by.yukhnevich.array.service.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.service.SortService;
import by.yukhnevich.array.validation.ArrayValidation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortServiceImplement implements SortService {
    private static final Logger LOGGER = LogManager.getLogger(SortServiceImplement.class);
    @Override
    public void bubbleSort(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }

        int[] tempArray = array.getArray();
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < tempArray.length; i++) {
                if (tempArray[i] < tempArray[i - 1]) {
                    int temp = tempArray[i];
                    tempArray[i] = tempArray[i - 1];
                    tempArray[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
        array.setArray(tempArray);
        LOGGER.log(Level.INFO, String.format("Bubble sort completed %s", array.toString()));
    }

    @Override
    public void insertSort(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }

        int[] tempArray = array.getArray();
        for (int i = 1; i < tempArray.length; i++) {
            int current = tempArray[i];
            int j = i;
            while (j > 0 && tempArray[j - 1] > current) {
                tempArray[j] = tempArray[j - 1];
                j--;
            }
            tempArray[j] = current;
        }
        array.setArray(tempArray);
        LOGGER.log(Level.INFO, String.format("Insert sort is done %s", array.toString()));
    }

    @Override
    public void selectionSort(CustomArray array) throws CustomArrayException {
        if (!ArrayValidation.validateArray(array)) {
            throw new CustomArrayException("Invalid input array [empty or null]");
        }

        int[] tempArray = array.getArray();
        for (int i = 0; i < tempArray.length; i++) {
            int min = tempArray[i];
            int minIterator = i;
            for (int j = i + 1; j < tempArray.length; j++) {
                if (tempArray[j] < min) {
                    min = tempArray[j];
                    minIterator = j;
                }
            }
            if (i != minIterator) {
                int tmp = tempArray[i];
                tempArray[i] = tempArray[minIterator];
                tempArray[minIterator] = tmp;
            }
        }
        array.setArray(tempArray);
        LOGGER.log(Level.DEBUG, "S");
        //LOGGER.log(Level.INFO, String.format("Selection sort is done %s", array.toString()));
    }
}
