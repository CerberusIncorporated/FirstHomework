package by.yukhnevich.array.validation.fileValidation;

import by.yukhnevich.array.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class FileNameValidation {
    private static Logger LOGGER = LogManager.getLogger(FileNameValidation.class);

    public boolean validateFile(String path) throws CustomArrayException {
        if (path == null) {
            LOGGER.info("The path equal to null");
            return false;
        }
        if (path.isBlank()) {
            LOGGER.info("The name of the path is empty");
            return false;
        }
        File file = new File(path);
        return file.exists() && file.length() > 0;
    }
}
