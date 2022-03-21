package by.yukhnevich.multithreading.reader;

import by.yukhnevich.multithreading.exception.SeaPortException;
import by.yukhnevich.multithreading.validator.ShipFileValidator;
import by.yukhnevich.multithreading.validator.impl.ShipFileValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ShipFileReader {
    private static final Logger logger = LogManager.getLogger();
    private final ShipFileValidator seaPortFileValidator = new ShipFileValidatorImpl();

    public List<String> readShipsFile(String filePath) throws SeaPortException {
        if (!seaPortFileValidator.isFileValid(filePath)) {
            throw new SeaPortException("Invalid file path");
        }
        Path path = Paths.get(filePath);
        try {
            List<String> fileLines = Files.readAllLines(path);
            if (!seaPortFileValidator.areFileLinesValid(fileLines)) {
                throw new SeaPortException("Invalid file lines");
            }
            logger.info("File lines read successfully");
            return fileLines;
        } catch (IOException e) {
            throw new SeaPortException("Can't read file: " + filePath, e);
        }
    }
}
