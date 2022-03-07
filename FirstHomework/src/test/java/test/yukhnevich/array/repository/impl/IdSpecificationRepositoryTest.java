package test.yukhnevich.array.repository.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.impl.CustomArrayRepositoryImpl;
import by.yukhnevich.array.repository.impl.IdSpecificationRepository;
import org.testng.Assert;
import org.testng.annotations.*;

public class IdSpecificationRepositoryTest {
    private IdSpecificationRepository idSpecificationRepository;
    private CustomArrayRepositoryImpl repository = null;
    private CustomArray array;
    private int expectedId;

    @BeforeTest
    public void setUp() {
        idSpecificationRepository = new IdSpecificationRepository(1);
        repository = CustomArrayRepositoryImpl.getInstance();
        array = null;
        expectedId = 1;

    }

    @Test
    public void specify() {
        array = new CustomArray(expectedId, new int[]{1, 2, 3});
        repository.addArray(array);
        Assert.assertEquals(repository.query(idSpecificationRepository).get(0).getId(), expectedId);
    }

    @AfterTest
    public void shutDown() {
        idSpecificationRepository = null;
        repository = null;
        array = null;
    }

}
