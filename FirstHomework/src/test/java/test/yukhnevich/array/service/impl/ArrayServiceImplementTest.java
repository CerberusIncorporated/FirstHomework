package test.yukhnevich.array.service.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.service.ArrayService;
import by.yukhnevich.array.service.impl.ArrayServiceImplement;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrayServiceImplementTest {
    private CustomArray array;
    private ArrayService arrayServiceImplement;
    private static final Logger logger = LogManager.getLogger();


    @BeforeClass
    public void init() {
        array = new CustomArray(5, 1, -6, 0, 45, 0, -19, 3);
        arrayServiceImplement = new ArrayServiceImplement();
        logger.info(String.format("All test is complete"), Level.INFO);

    }

    @Test
    public void findMaxNumberTest() throws CustomArrayException {
        int expected = 45;
        int result = arrayServiceImplement.findMaxNumber(array);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void findMinNumberTest() throws CustomArrayException {
        int expected = -19;
        int result = arrayServiceImplement.findMinNumber(array);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void findSumOfArrayTest() throws CustomArrayException {
        long expected = 29;
        long result = arrayServiceImplement.findSumOfArray(array);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void findPositiveNumbersTest() throws CustomArrayException {
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
    public void findAverageNumberTest() throws CustomArrayException {
        int expected = 3;
        int result = arrayServiceImplement.findAverageNumber(array);
        Assert.assertEquals(expected, result);
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
        logger.info("All test is complete");
    }
}
