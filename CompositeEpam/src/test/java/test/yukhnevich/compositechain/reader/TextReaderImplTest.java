package test.yukhnevich.compositechain.reader;

import by.yukhnevich.compositechain.exception.CustomTextException;
import by.yukhnevich.compositechain.reader.TextReader;
import by.yukhnevich.compositechain.reader.impl.TextReaderImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TextReaderImplTest {
    private static final String TEST_TEXTS_PATH = "testtexts/";

    private TextReader reader;

    @DataProvider(name = "textPr")
    public Object[][] createDataForAvg() {
        return new Object[][]{
                {"reader_1.txt", "Lorem"},
                {"reader_2.txt", "\tHello, old friend. \t12+23*(12-13)/25-1. "},
                {"reader_3.txt", ""}
        };
    }

    @BeforeClass
    public void setUp() {
        reader = new TextReaderImpl();
    }

    @Test(dataProvider = "textPr")
    public void testReadTextFromFile(String textName, String expected) {

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            URL resource = classLoader.getResource(TEST_TEXTS_PATH + textName);
            File file = new File(resource.toURI());
            String actual = reader.readTextFromFile(file.getAbsolutePath());

                assertEquals(actual, expected);
        } catch (URISyntaxException | CustomTextException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = CustomTextException.class,
            expectedExceptionsMessageRegExp = "Error while reading file: " + TEST_TEXTS_PATH + "notexisting.txt")
    public void testReadTextFromNotExistingFile() throws CustomTextException {
        reader.readTextFromFile(TEST_TEXTS_PATH + "notexisting.txt");
    }
}
