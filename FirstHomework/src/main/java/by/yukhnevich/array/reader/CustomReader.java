package by.yukhnevich.array.reader;

import by.yukhnevich.array.exception.CustomArrayException;

import java.util.List;

public interface CustomReader {
    List<String> readFromFile(String path) throws CustomArrayException;
}
