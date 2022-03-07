package by.yukhnevich.array.validation;

import by.yukhnevich.array.entity.CustomArray;

public class ArrayValidation {
    private ArrayValidation() {
    }

    public static boolean validateArray(CustomArray array) {
        try {
            return array != null && array.getArray().length != 0;
        } catch (Exception exception) {
            return false;
        }
    }
}
