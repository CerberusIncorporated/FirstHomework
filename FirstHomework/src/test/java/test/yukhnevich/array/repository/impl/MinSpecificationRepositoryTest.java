package test.yukhnevich.array.repository.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.impl.CustomArrayRepositoryImpl;
import by.yukhnevich.array.repository.impl.MinSpecificationRepository;
import by.yukhnevich.array.service.impl.ArrayServiceStreamImplement;
import by.yukhnevich.array.util.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.OptionalInt;

public class MinSpecificationRepositoryTest {

    private MinSpecificationRepository specification;
    private ArrayServiceStreamImplement action;
    private CustomArrayRepositoryImpl repository;

    @BeforeTest
    public void setUp() {
        specification = new MinSpecificationRepository(3);
        action = new ArrayServiceStreamImplement();
        repository = CustomArrayRepositoryImpl.getInstance();
    }

    @Test
    public void specify() {
        int expectedMin = 3;
        repository.addArray(new CustomArray(IdGenerator.generateId(), new int[]{1, 2, 3}));
        repository.addArray(new CustomArray(IdGenerator.generateId(), new int[]{8, 5, 3}));
        OptionalInt min = action.findMinNumber(repository.query(specification).get(0));
        Assert.assertEquals(min.getAsInt(), expectedMin);
    }

    @AfterTest
    public void shutDown() {
        specification = null;
        action = null;
        repository = null;
    }

}
