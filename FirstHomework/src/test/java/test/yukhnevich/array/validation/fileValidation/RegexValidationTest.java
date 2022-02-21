package test.yukhnevich.array.validation.fileValidation;

import by.yukhnevich.array.validation.fileValidation.RegexValidation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegexValidationTest {
    private final RegexValidation validator = new RegexValidation();

    @Test
    public void equalsToRegex() {
        Assert.assertTrue(validator.validateRegex("1 34 -6"));
    }

    @Test
    public void notEqualsRegex() {
        Assert.assertFalse(validator.validateRegex("rt 24 4"));
    }
}
