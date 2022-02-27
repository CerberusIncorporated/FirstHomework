package by.yukhnevich.array.service;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface ArrayService {

    OptionalInt findMinNumber(CustomArray array) throws CustomArrayException;

    OptionalInt findMaxNumber(CustomArray array) throws CustomArrayException;

    OptionalLong findSumOfArray(CustomArray array) throws CustomArrayException;

    int findPositiveNumbers(CustomArray array) throws CustomArrayException;

    int findNegativeNumbers(CustomArray array) throws CustomArrayException;

    OptionalDouble findAverageNumber(CustomArray array) throws CustomArrayException;

    void replaceNegativeNumbers(CustomArray array) throws CustomArrayException;
}
