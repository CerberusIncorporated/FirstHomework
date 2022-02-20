package by.yukhnevich.array.service;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;

public interface SortService {

    void bubbleSort(CustomArray array) throws CustomArrayException;

    void insertSort(CustomArray array) throws CustomArrayException;

    void selectionSort(CustomArray array) throws CustomArrayException;

}
