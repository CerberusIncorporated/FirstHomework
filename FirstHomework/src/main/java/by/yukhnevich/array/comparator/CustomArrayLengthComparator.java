package by.yukhnevich.array.comparator;

import by.yukhnevich.array.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayLengthComparator implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return o1.getArray().length - o2.getArray().length;
    }
}
