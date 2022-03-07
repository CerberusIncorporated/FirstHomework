package test.yukhnevich.array.repository.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.impl.CustomArrayRepositoryImpl;
import by.yukhnevich.array.repository.impl.SumSpecificationRepository;
import by.yukhnevich.array.service.impl.ArrayServiceStreamImplement;
import by.yukhnevich.array.util.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.OptionalLong;

public class SumSpecificationRepositoryTest {
    private SumSpecificationRepository specification = null;
    private ArrayServiceStreamImplement action = null;
    private CustomArrayRepositoryImpl repository = null;
    private CustomArray expectedArray = null;
    private OptionalLong expectedSum = null;

    @BeforeTest
    public void setUp() {
        specification = new SumSpecificationRepository(10);
        action = new ArrayServiceStreamImplement();
        repository = CustomArrayRepositoryImpl.getInstance();
        expectedArray = new CustomArray(IdGenerator.generateId(), new int[]{1, 8, 5});
        expectedSum = null;
    }

    @Test
    public void specify() {
        repository.addArray(new CustomArray(IdGenerator.generateId(), new int[]{1, -5, 6, -8}));
        repository.addArray(expectedArray);
        expectedSum = action.findSumOfArray(expectedArray);
        Assert.assertEquals(action.findSumOfArray(repository.query(specification).get(0)), expectedSum);
    }

    @AfterTest
    public void shutDown() {
        specification = null;
        action = null;
        repository = null;
        expectedArray = null;
        expectedSum = null;
    }
}
