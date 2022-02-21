package by.yukhnevich.array.parser;

import by.yukhnevich.array.exception.CustomArrayException;

public class CustomParser {
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
