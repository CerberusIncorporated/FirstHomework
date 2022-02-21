package by.yukhnevich.array.parser;

import by.yukhnevich.array.exception.CustomArrayException;

public interface CustomParser {

    int[] parse(String str) throws CustomArrayException;

}
