package test.yukhnevich.array.service.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.service.SortService;
import by.yukhnevich.array.service.impl.SortServiceStreamImplement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SortServiceStreamImplementTest {
    private CustomArray array;
    private SortService sortService;

    @BeforeTest
    public void init() {
        array = new CustomArray(9, 8, 7, 2, 6, 1, 5, 4, 3);
        sortService = new SortServiceStreamImplement();
    }

    @Test
    public void bubbleSortTest() throws CustomArrayException {
        String expected = "CustomArray{array=[1, 2, 3, 4, 5, 6, 7, 8, 9]}";
        sortService.bubbleSort(array);
        String result = array.toString();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void insertSortTest() throws CustomArrayException {
        String expected = "CustomArray{array=[1, 2, 3, 4, 5, 6, 7, 8, 9]}";
        sortService.insertSort(array);
        String result = array.toString();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void selectionSortTest() throws CustomArrayException {
        String expected = "CustomArray{array=[1, 2, 3, 4, 5, 6, 7, 8, 9]}";
        sortService.selectionSort(array);
        String result = array.toString();
        Assert.assertEquals(expected, result);
    }

    @AfterTest
    public void terminate() {
        array.setArray(null);
        sortService = null;
    }
}