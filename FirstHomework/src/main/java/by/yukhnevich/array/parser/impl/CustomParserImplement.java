package by.yukhnevich.array.parser.impl;

import by.yukhnevich.array.exception.CustomArrayException;
import by.yukhnevich.array.parser.CustomParser;

public class CustomParserImplement implements CustomParser {
    private final static String SPACE_REGEX = "\\s+";

    public int[] parse(String string) throws CustomArrayException {
        if (string == null || string.isBlank()) {
            throw new CustomArrayException("Parsing line impossible");
        }
        String[] stringArray = string.split(SPACE_REGEX);
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            int number = Integer.parseInt(stringArray[i]);
            intArray[i] = number;
        }
        return intArray;
    }
}
