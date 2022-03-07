package test.yukhnevich.xmltask.validator.impl;

import by.yukhnevich.xmltask.exception.GemException;
import by.yukhnevich.xmltask.validator.impl.GemXmlValidatorImplement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GemXmlValidatorImplementTest {
    private static final String XML_FILE = "data/gem_2.xml";
    private static final String XML_FILE_WRONG = "data/gem_wrong.xml";
    private GemXmlValidatorImplement validator;

    @BeforeClass
    public void setUp() {
        validator = GemXmlValidatorImplement.getInstance();
    }

    @Test
    public void testIsValidXML() {

        boolean actual = false;
        try {
            actual = validator.validateXML(XML_FILE);
        } catch (GemException e) {
            fail(e.getMessage(),e);
        }
        assertTrue(actual);
    }

    @Test
    public void testIsNotValid() {

        boolean actual = false;
        try {
            actual = validator.validateXML(XML_FILE_WRONG);
        } catch (GemException e) {
            fail(e.getMessage(),e);
        }
        assertFalse(actual);
    }
}
