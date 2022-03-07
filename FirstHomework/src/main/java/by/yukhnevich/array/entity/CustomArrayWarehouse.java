package by.yukhnevich.array.entity;

import java.util.*;

public class CustomArrayWarehouse {
    private Map<Integer, CustomArrayParameters> warehouse;
    private static CustomArrayWarehouse instance;

    private CustomArrayWarehouse() {
        warehouse = new HashMap<>();
    }

    public static CustomArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new CustomArrayWarehouse();
        }
        return instance;
    }

    public CustomArrayParameters get(int arrayId) {
        return warehouse.get(arrayId);
    }

    public CustomArrayParameters put(int arrayId, CustomArrayParameters parameter) {
        return warehouse.put(arrayId, parameter);
    }

    public CustomArrayParameters remove(int arrayId) {
        return warehouse.remove(arrayId);
    }

    public CustomArrayParameters clear(int arrayId) {
        return warehouse.replace(arrayId, new CustomArrayParameters(OptionalInt.empty(),
                OptionalInt.empty(), OptionalLong.empty(), OptionalDouble.empty()));
    }
}
