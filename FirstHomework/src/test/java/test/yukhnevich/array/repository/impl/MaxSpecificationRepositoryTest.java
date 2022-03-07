package test.yukhnevich.array.repository.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.impl.CustomArrayRepositoryImpl;
import by.yukhnevich.array.repository.impl.MaxSpecificationRepository;
import by.yukhnevich.array.service.impl.ArrayServiceStreamImplement;
import by.yukhnevich.array.util.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.OptionalInt;

public class MaxSpecificationRepositoryTest {
    private MaxSpecificationRepository specification = null;
    private ArrayServiceStreamImplement action = null;
    private CustomArrayRepositoryImpl repository = null;

    @BeforeTest
    public void setUp() {
        specification = new MaxSpecificationRepository(8);
        action = new ArrayServiceStreamImplement();
        repository = CustomArrayRepositoryImpl.getInstance();

    }

    @Test
    public void specify() {
        int expectedMax = 8;
        repository.addArray(new CustomArray(IdGenerator.generateId(), new int[]{1, 2, 3}));
        repository.addArray(new CustomArray(IdGenerator.generateId(), new int[]{8, 5, 3}));
        OptionalInt max = action.findMaxNumber(repository.query(specification).get(0));
        Assert.assertEquals(max.getAsInt(), expectedMax);
    }

    @AfterTest
    public void shutDown() {
        specification = null;
        action = null;
        repository = null;
    }
}
