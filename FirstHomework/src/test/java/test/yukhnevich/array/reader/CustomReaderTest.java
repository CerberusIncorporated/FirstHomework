package test.yukhnevich.array.reader;

import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.reader.CustomReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomReaderTest {
    private CustomReader customReader;

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
        customReader = new CustomReader();
    }

    @Test(expectedExceptions = CustomArrayException.class, dataProvider = "parseExceptionData")
    public void readLineExceptionTest(String path) throws CustomArrayException {
        customReader.readFromFile(path);
    }

    @Test
    public void readLineTest() {
        try {
            String expected = "[qwoejp, 123, - 52, 1, 2w, 3, -1 -2 -3, -1 - -2 -3, -4]";
            String actual = customReader.readFromFile("src/main/resources/data/data.txt").toString();
            Assert.assertEquals(expected, actual);
        } catch (CustomArrayException e) {
            Assert.fail();
        }
    }

    @AfterClass
    public void terminate() {
        customReader = null;
    }
}
