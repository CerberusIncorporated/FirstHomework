package by.yukhnevich.array.service.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.entity.CustomArrayParameters;
import by.yukhnevich.array.entity.CustomArrayWarehouse;
import by.yukhnevich.array.service.CustomWarehouseService;
import by.yukhnevich.array.util.IdGenerator;

import java.util.*;

public class CustomWarehouseServiceImpl implements CustomWarehouseService {
    @Override
    public void putArrayInWarehouse(CustomArray array) {
        CustomArrayWarehouse warehouseService = CustomArrayWarehouse.getInstance();
        ArrayServiceStreamImplement streamImplement = new ArrayServiceStreamImplement();

        int id = array.getId();
        OptionalLong sum = streamImplement.findSumOfArray(array);
        OptionalInt min = streamImplement.findMinNumber(array);
        OptionalInt max = streamImplement.findMaxNumber(array);
        OptionalDouble avg = streamImplement.findAverageNumber(array);
        CustomArrayParameters parameters = new CustomArrayParameters();
        parameters.setSum(sum);
        if (min.isPresent()) {
            parameters.setMin(min);
        }
        if (max.isPresent()) {
            parameters.setMax(max);
        }
        if (avg.isPresent()) {
            parameters.setAverage(avg);
        }
        warehouseService.put(id, parameters);
    }

    @Override
    public void putNumbersInWarehouse(int... args) {
        CustomArray array = new CustomArray(IdGenerator.generateId(), args);
        putArrayInWarehouse(array);
    }

    @Override
    public void putNumbersInWarehouse(int id, int[] args) {
        CustomArray array = new CustomArray(id, args);
        putArrayInWarehouse(array);
    }

    @Override
    public void putListInWarehouse(List<CustomArray> array) {
        for (CustomArray customArray : array) {
            putArrayInWarehouse(customArray);
        }
    }
}
