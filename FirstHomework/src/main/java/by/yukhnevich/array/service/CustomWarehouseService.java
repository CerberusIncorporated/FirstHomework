package by.yukhnevich.array.service;

import by.yukhnevich.array.entity.CustomArray;

import java.util.List;

public interface CustomWarehouseService {
    void putArrayInWarehouse(CustomArray array);

    void putNumbersInWarehouse(int... args);

    void putNumbersInWarehouse(int id, int[] args);

    void putListInWarehouse(List<CustomArray> array);
}
