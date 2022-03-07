package test.yukhnevich.array.repository.impl;

import by.yukhnevich.array.comparator.CustomArrayLengthComparator;
import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.impl.CustomArrayRepositoryImpl;
import by.yukhnevich.array.repository.impl.IdSpecificationRepository;
import by.yukhnevich.array.util.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayRepositoryImplTest {
    private CustomArrayRepositoryImpl arrayRepository;
    private CustomArray expectedArray;
    private CustomArrayLengthComparator numbersComparator;
    private IdSpecificationRepository idSpecification;
    private List<CustomArray> customArrayList;

    @BeforeTest
    public void setUp() {
        arrayRepository = CustomArrayRepositoryImpl.getInstance();
        expectedArray = new CustomArray(IdGenerator.generateId(), new int[]{1, 5, 6});
        numbersComparator = new CustomArrayLengthComparator();
        idSpecification = new IdSpecificationRepository(0);
        customArrayList = new ArrayList<>();
    }

    @Test
    public void addArray() {
        arrayRepository.addArray(expectedArray);
        Assert.assertEquals(arrayRepository.get(0), expectedArray);
    }

    @Test
    public void addAllArrays() {
        customArrayList.add(expectedArray);
        arrayRepository.addAllArrays(customArrayList);
        Assert.assertEquals(arrayRepository.get(0), expectedArray);
    }

    @Test
    public void removeArray() {
        arrayRepository.addArray(expectedArray);
        Assert.assertTrue(arrayRepository.removeArray(expectedArray));
    }

    @Test
    public void removeAllArrays() {
        customArrayList.add(expectedArray);
        arrayRepository.addAllArrays(customArrayList);
        Assert.assertTrue(arrayRepository.removeAllArrays(customArrayList));
    }

    @Test
    public void query() {
        arrayRepository.addArray(expectedArray);
        Assert.assertEquals(arrayRepository.query(idSpecification).get(0), expectedArray);
    }

    @Test
    public void sort() {
        arrayRepository.addArray(new CustomArray(IdGenerator.generateId(), new int[]{0, 0, 0, 0}));
        arrayRepository.addArray(expectedArray);
        Assert.assertEquals(arrayRepository.sort(numbersComparator).get(0), expectedArray);
    }

    @AfterTest
    public void shutDown() {
        arrayRepository = null;
        expectedArray = null;
        numbersComparator = null;
        idSpecification = null;
        customArrayList = null;
    }
}
