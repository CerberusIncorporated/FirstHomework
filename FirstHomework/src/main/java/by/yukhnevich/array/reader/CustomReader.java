package by.yukhnevich.array.reader;

import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.validation.fileValidation.FileNameValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomReader {
    static Logger LOGGER = LogManager.getLogger(CustomReader.class);
    private static final FileNameValidation fileNameValidator = new FileNameValidation();

    public List<String> readFromFile(String path) throws CustomArrayException {

        if (!fileNameValidator.validateFile(path)) {
            LOGGER.info("Reading from the file impossible");
            throw new CustomArrayException("Reading from the file impossible");
        }
        List<String> list = new ArrayList<>();
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {

                list.add(scanner.nextLine());
            }
        } catch (Exception e) {
            LOGGER.info("Reading from the file impossible");
            throw new CustomArrayException(e);
        }
        LOGGER.info("The file has read successfully and you have a new  string array list");
        return list;
    }
}
