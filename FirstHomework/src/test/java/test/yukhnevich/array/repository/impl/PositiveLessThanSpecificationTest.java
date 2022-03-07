package test.yukhnevich.array.repository.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.impl.CustomArrayRepositoryImpl;
import by.yukhnevich.array.repository.impl.PositiveLessThanSpecification;
import by.yukhnevich.array.service.impl.ArrayServiceStreamImplement;
import by.yukhnevich.array.util.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.*;

public class PositiveLessThanSpecificationTest {
    private PositiveLessThanSpecification specification = null;
    private ArrayServiceStreamImplement action = null;
    private CustomArrayRepositoryImpl repository = null;
    private CustomArray expectedArray;

    @BeforeTest
    public void setUp() {
        specification = new PositiveLessThanSpecification(4);
        action = new ArrayServiceStreamImplement();
        repository = CustomArrayRepositoryImpl.getInstance();
        expectedArray = new CustomArray(IdGenerator.generateId(), new int[]{1, -2, 3});
    }

    @Test
    public void specify() {
        repository.addArray(new CustomArray(IdGenerator.generateId(), new int[]{4, 5, 6, 8, 7}));
        repository.addArray(expectedArray);
        long expectedPositive = action.findPositiveNumbers(expectedArray);
        Assert.assertEquals(action.findPositiveNumbers(repository.query(specification).get(0)), expectedPositive);
    }

    @AfterTest
    public void shutDown() {
        specification = null;
        action = null;
        repository = null;
        expectedArray = null;
    }
}
