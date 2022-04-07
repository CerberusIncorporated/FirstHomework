package by.yukhnevich.compositechain.reader;

import by.yukhnevich.compositechain.exception.CustomTextException;

public interface TextReader {
    String readTextFromFile(String filepath) throws CustomTextException;
}
