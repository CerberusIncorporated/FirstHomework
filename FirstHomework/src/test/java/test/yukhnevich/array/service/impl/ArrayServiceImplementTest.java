package test.yukhnevich.array.service.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.service.ArrayService;
import by.yukhnevich.array.service.impl.ArrayServiceImplement;
import by.yukhnevich.array.util.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class ArrayServiceImplementTest {
    private CustomArray array;
    private ArrayService arrayServiceImplement;

    @BeforeClass
    public void init() {
        array = new CustomArray(IdGenerator.generateId(), 5, 1, -6, 0, 45, 0, -19, 3);
        arrayServiceImplement = new ArrayServiceImplement();
    }

    @Test
    public void findMaxNumberTest() {
        int expected = 45;
        OptionalInt result = arrayServiceImplement.findMaxNumber(array);
        Assert.assertEquals(expected, result.getAsInt());
    }

    @Test
    public void findMinNumberTest() {
        int expected = -19;
        OptionalInt result = arrayServiceImplement.findMinNumber(array);
        Assert.assertEquals(expected, result.getAsInt());
    }

    @Test
    public void findSumOfArrayTest() {
        long expected = 29;
        OptionalLong result = arrayServiceImplement.findSumOfArray(array);
        Assert.assertEquals(expected, result.getAsLong());
    }

    @Test
    public void findPositiveNumbersTest() {
        int expected = 6;
        int result = arrayServiceImplement.findPositiveNumbers(array);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void findNegativeNumbersTest() throws CustomArrayException {
        int expected = 2;
        int result = arrayServiceImplement.findNegativeNumbers(array);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void findAverageNumberTest() {
        double expected = 3;
        OptionalDouble result = arrayServiceImplement.findAverageNumber(array);
        Assert.assertEquals(expected, result.getAsDouble());
    }

    @Test
    public void replaceNegativeNumbersTest() throws CustomArrayException {
        String expected = "CustomArray{array=[5, 1, -1, 0, 45, 0, -1, 3]}";
        arrayServiceImplement.replaceNegativeNumbers(array);
        String result = array.toString();
        Assert.assertEquals(expected, result);
    }

    @AfterClass
    public void terminate() {
        array = null;
        arrayServiceImplement = null;
    }
}
