package test.yukhnevich.array.validation;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.validation.ArrayValidation;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayValidationTest {

    @DataProvider(name = "validateArrayData")
    public Object[][] getData() {
        return new Object[][]{
                {null, false},
                {new CustomArray(), false},
                {new CustomArray(1, 4, 2), true}
        };
    }

    @Test(dataProvider = "validateArrayData")
    public void validateArrayTest(CustomArray array, boolean expected) throws CustomArrayException {
        boolean actual = ArrayValidation.validateArray(array);
        AssertJUnit.assertEquals(expected, actual);
    }
}
