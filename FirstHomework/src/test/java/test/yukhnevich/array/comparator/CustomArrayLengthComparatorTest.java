package test.yukhnevich.array.comparator;

import by.yukhnevich.array.comparator.CustomArrayLengthComparator;
import by.yukhnevich.array.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomArrayLengthComparatorTest {
    private final CustomArrayLengthComparator idComparator = new CustomArrayLengthComparator();

    @Test
    public void compare() {
        long expectedCompare = 0;
        CustomArray firstArray = new CustomArray(2, new int[]{12, 76, 24});
        CustomArray secondArray = new CustomArray(15, new int[]{1, 2, 3});
        Assert.assertEquals(idComparator.compare(firstArray, secondArray), expectedCompare);
    }
}
