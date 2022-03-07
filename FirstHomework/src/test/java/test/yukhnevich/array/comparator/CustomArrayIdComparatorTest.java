package test.yukhnevich.array.comparator;

import by.yukhnevich.array.comparator.CustomArrayIdComparator;
import by.yukhnevich.array.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomArrayIdComparatorTest {
    private final CustomArrayIdComparator idComparator = new CustomArrayIdComparator();

    @Test
    public void compare() {
        long expectedCompare = 0;
        CustomArray firstArray = new CustomArray(15, new int[]{});
        CustomArray secondArray = new CustomArray(15, new int[]{1, 2, 3});
        Assert.assertEquals(idComparator.compare(firstArray, secondArray), expectedCompare);
    }
}
