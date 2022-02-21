package test.yukhnevich.array.parser;

import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.parser.CustomParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomParserTest {
    private final CustomParser parser = new CustomParser();

    @Test
    public void parseTest() throws CustomArrayException {
        String stringForParsing = "1 5 8 2";
        int[] expectedArray = new int[]{1, 5, 8, 2};
        int[] actualArray = parser.parse(stringForParsing);

        Assert.assertEquals(actualArray, expectedArray);
    }
}
