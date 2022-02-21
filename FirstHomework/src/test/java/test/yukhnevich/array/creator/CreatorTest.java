package test.yukhnevich.array.creator;

import by.yukhnevich.array.creator.Creator;
import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatorTest {
    private final Creator creator = new Creator();

    @Test
    public void createCorrectEntity() throws CustomArrayException {
        CustomArray expectedArrayEntity = new CustomArray(-1, -2, -3);
        CustomArray actualArrayEntity = creator.createEntity("src\\main\\resources\\data\\data.txt");
        Assert.assertEquals(actualArrayEntity, expectedArrayEntity);
    }

}
