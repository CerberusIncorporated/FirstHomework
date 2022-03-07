package test.yukhnevich.array.reader;

import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.reader.impl.CustomReaderImplement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomReaderImplementTest {
    private CustomReaderImplement customReaderImplement;

    @DataProvider(name = "parseExceptionData")
    public Object[][] getExceptionData() {
        return new Object[][]{
                new Object[]{""},
                new Object[]{"wrong"},
                new Object[]{null}
        };
    }

    @BeforeClass
    public void init() {
        customReaderImplement = new CustomReaderImplement();
    }

    @Test(expectedExceptions = CustomArrayException.class, dataProvider = "parseExceptionData")
    public void readLineExceptionTest(String path) throws CustomArrayException {
        customReaderImplement.readFromFile(path);
    }

    @Test
    public void readLineTest() {
        try {
            String expected = "[qwoejp, 123, - 52, 1, 2w, 3, -1 -2 -3, -1 - -2 -3, -4]";
            String actual = customReaderImplement.readFromFile("src/test/resources/data.txt").toString();
            Assert.assertEquals(expected, actual);
        } catch (CustomArrayException e) {
            Assert.fail();
        }
    }

    @AfterClass
    public void terminate() {
        customReaderImplement = null;
    }
}
