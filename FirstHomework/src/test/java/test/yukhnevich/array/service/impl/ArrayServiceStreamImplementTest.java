package test.yukhnevich.array.service.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.service.ArrayService;
import by.yukhnevich.array.service.impl.ArrayServiceStreamImplement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrayServiceStreamImplementTest {
    private CustomArray array;
    private ArrayService arrayServiceStreamImplement;

    @BeforeClass
    public void init() {
        array = new CustomArray(5, 1, -6, 0, 45, 0, -19, 3);
        arrayServiceStreamImplement = new ArrayServiceStreamImplement();
    }

    @Test
    public void findMaxNumberTest() throws CustomArrayException {
        int expected = 45;
        int result = arrayServiceStreamImplement.findMaxNumber(array);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void findMinNumberTest() throws CustomArrayException {
        int expected = -19;
        int result = arrayServiceStreamImplement.findMinNumber(array);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void findSumOfArrayTest() throws CustomArrayException {
        long expected = 29;
        long result = arrayServiceStreamImplement.findSumOfArray(array);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void findPositiveNumbersTest() throws CustomArrayException {
        int expected = 6;
        int result = arrayServiceStreamImplement.findPositiveNumbers(array);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void findNegativeNumbersTest() throws CustomArrayException {
        int expected = 2;
        int result = arrayServiceStreamImplement.findNegativeNumbers(array);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void findAverageNumberTest() throws CustomArrayException {
        double expected = 3.625;
        double result = arrayServiceStreamImplement.findAverageNumber(array);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void replaceNegativeNumbersTest() throws CustomArrayException {
        String expected = "CustomArray{array=[5, 1, -1, 0, 45, 0, -1, 3]}";
        arrayServiceStreamImplement.replaceNegativeNumbers(array);
        String result = array.toString();
        Assert.assertEquals(expected, result);
    }

    @AfterClass
    public void terminate() {
        array = null;
        arrayServiceStreamImplement = null;
    }
}
