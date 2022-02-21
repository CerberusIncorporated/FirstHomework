package test.yukhnevich.array.validation.fileValidation;

import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.validation.fileValidation.FileNameValidation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileNameValidationTest {
    private final FileNameValidation validator = new FileNameValidation();

    @Test
    public void fileNameEqualToNull() throws CustomArrayException {
        Assert.assertFalse(validator.validateFile(null));
    }

    @Test
    public void fileNotExistsTest() throws CustomArrayException {
        Assert.assertFalse(validator.validateFile("src\\main\\resources\\data\\data1.txt"));
    }

    @Test
    public void fileExistsTest() throws CustomArrayException {
        Assert.assertTrue(validator.validateFile("src\\main\\resources\\data\\data.txt"));
    }

    @Test
    public void fileIsEmpty() throws CustomArrayException {
        Assert.assertFalse(validator.validateFile("src\\main\\resources\\data\\emptyFile.txt"));
    }

    @Test
    public void fileExistAndIsNotEmpty() throws CustomArrayException {
        Assert.assertTrue(validator.validateFile("src\\main\\resources\\data\\data.txt"));
    }

    @Test
    public void pathIsEmpty() throws CustomArrayException {
        Assert.assertFalse(validator.validateFile(""));
    }
}
