package by.yukhnevich.array.validation;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;

public class ArrayValidation {
    private ArrayValidation() {
    }

    public static boolean validateArray(CustomArray array) throws CustomArrayException {
        return array != null && array.getArray().length != 0;
    }
}
