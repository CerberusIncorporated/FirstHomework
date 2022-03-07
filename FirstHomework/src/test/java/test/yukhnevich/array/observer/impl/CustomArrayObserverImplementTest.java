package test.yukhnevich.array.observer.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.entity.CustomArrayParameters;
import by.yukhnevich.array.entity.CustomArrayWarehouse;
import by.yukhnevich.array.observer.CustomArrayEvent;
import by.yukhnevich.array.observer.impl.CustomArrayObserverImplement;
import by.yukhnevich.array.service.impl.CustomWarehouseServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class CustomArrayObserverImplementTest {
    private static CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
    private static CustomArrayObserverImplement observerImplement = new CustomArrayObserverImplement();
    private static CustomArray customArray = new CustomArray(1, 10, 15, 20);
    private static final int REAL_ID = 1;
    private static CustomArrayEvent event = new CustomArrayEvent(customArray);

    @BeforeTest
    public void setUp() {
        CustomWarehouseServiceImpl warehouseService = new CustomWarehouseServiceImpl();
        warehouseService.putArrayInWarehouse(customArray);
    }

    @Test
    public void clearParameters() {
        CustomArrayParameters expectedParameters = new CustomArrayParameters();
        observerImplement.clearParameters(event);
        Assert.assertEquals(warehouse.get(REAL_ID), expectedParameters);
    }

    @Test
    public void changedParameters() {
        int[] change = {1, 2, 3, 4, 5};
        CustomArrayParameters expectedParameters = new CustomArrayParameters(OptionalInt.of(5), OptionalInt.of(1), OptionalLong.of(15), OptionalDouble.of(3));
        customArray.setArray(change);
        observerImplement.changedParameters(event);
        Assert.assertEquals(warehouse.get(REAL_ID), expectedParameters);
    }
}
