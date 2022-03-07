package test.yukhnevich.array.repository.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.impl.CustomArrayRepositoryImpl;
import by.yukhnevich.array.repository.impl.LengthSpecificationRepository;
import by.yukhnevich.array.util.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.*;

public class LengthSpecificationRepositoryTest {
    private LengthSpecificationRepository specificationRepository = null;
    private CustomArray expectedArray = null;
    private CustomArrayRepositoryImpl repository = null;

    @BeforeTest
    public void setUp() {
        specificationRepository = new LengthSpecificationRepository(3);
        expectedArray = new CustomArray(IdGenerator.generateId(), new int[]{1, 2, 3});
        repository = CustomArrayRepositoryImpl.getInstance();
    }

    @Test
    public void specify() {
        repository.addArray(new CustomArray(IdGenerator.generateId(), new int[]{4, 5, 6, 7}));
        repository.addArray(expectedArray);
        Assert.assertEquals(repository.query(specificationRepository).get(0), expectedArray);

    }

    @AfterTest
    public void shutDown() {
        specificationRepository = null;
        expectedArray = null;
        repository = null;
    }
}
