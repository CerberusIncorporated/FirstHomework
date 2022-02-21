package by.yukhnevich.array.service;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;

public interface ArrayService {

    int findMinNumber(CustomArray array) throws CustomArrayException;

    int findMaxNumber(CustomArray array) throws CustomArrayException;

    long findSumOfArray(CustomArray array) throws CustomArrayException;

    int findPositiveNumbers(CustomArray array) throws CustomArrayException;

    int findNegativeNumbers(CustomArray array) throws CustomArrayException;

    double findAverageNumber(CustomArray array) throws CustomArrayException;

    void replaceNegativeNumbers(CustomArray array) throws CustomArrayException;
}
