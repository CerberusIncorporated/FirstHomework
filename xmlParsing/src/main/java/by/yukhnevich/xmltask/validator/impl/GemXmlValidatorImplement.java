package by.yukhnevich.xmltask.validator.impl;

import by.yukhnevich.xmltask.handler.GemErrorHandler;
import by.yukhnevich.xmltask.exception.GemException;
import by.yukhnevich.xmltask.validator.GemXmlValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GemXmlValidatorImplement implements GemXmlValidator {
    private static final Logger logger = LogManager.getLogger();

    private static final String SCHEMA_NAME = "schema/gem.xsd";

    private static GemXmlValidatorImplement instance;

    private GemXmlValidatorImplement() {
    }

    public static GemXmlValidatorImplement getInstance() {
        if (instance == null) {
            instance = new GemXmlValidatorImplement();
        }
        return instance;
    }

    @Override
    public boolean validateXML(String xmlFile) throws GemException {

        String xmlPath = "";

        try {
            ClassLoader loader = this.getClass().getClassLoader();

            URL resource = loader.getResource(SCHEMA_NAME);
            File schemaFile = new File(resource.getFile());
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();

            URL resourceXML = loader.getResource(xmlFile);
            xmlPath = new File(resourceXML.getFile()).getPath();
            Source source = new StreamSource(xmlPath);

            validator.setErrorHandler(new GemErrorHandler());
            validator.validate(source);

        } catch (NullPointerException e) {
            logger.info(e.getMessage());
            throw new GemException(e.getMessage(), e);
        } catch (IOException e) {
            logger.info(e.getMessage());
            throw new GemException("Cannot open file: " + xmlPath, e);
        } catch (SAXException e) {
            logger.info(e.getMessage());
            return false;
        }

        return true;
    }
}
