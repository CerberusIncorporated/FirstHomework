package by.yukhnevich.array.service;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface ArrayService {

    OptionalInt findMinNumber(CustomArray array);

    OptionalInt findMaxNumber(CustomArray array);

    OptionalLong findSumOfArray(CustomArray array);

    int findPositiveNumbers(CustomArray array);

    int findNegativeNumbers(CustomArray array) throws CustomArrayException;

    OptionalDouble findAverageNumber(CustomArray array);

    void replaceNegativeNumbers(CustomArray array) throws CustomArrayException;
}
