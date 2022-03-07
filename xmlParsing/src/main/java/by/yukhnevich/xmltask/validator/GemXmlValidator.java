package by.yukhnevich.xmltask.validator;

import by.yukhnevich.xmltask.exception.GemException;

public interface GemXmlValidator {
    boolean validateXML(String xmlFile) throws GemException;
}
