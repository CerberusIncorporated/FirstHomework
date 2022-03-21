package by.yukhnevich.multithreading.validator;

import java.util.List;

public interface ShipFileValidator {

    boolean isFileValid(String filePath);

    boolean areFileLinesValid(List<String> fileLines);
}
