package by.yukhnevich.array.service.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.impl.CustomArrayRepositoryImpl;
import by.yukhnevich.array.service.CustomRepositoryService;
import by.yukhnevich.array.util.IdGenerator;

import java.util.List;

public class CustomRepositoryServiceImplement implements CustomRepositoryService {


    @Override
    public void addArrayInRepo(CustomArray array) {
        CustomArrayRepositoryImpl arrayRepository = new CustomArrayRepositoryImpl();
        arrayRepository.addArray(array);
        CustomWarehouseServiceImpl filter = new CustomWarehouseServiceImpl();
        filter.putArrayInWarehouse(array);
    }

    @Override
    public void addNumberInRepo(int... args) {
        CustomArray array = new CustomArray(IdGenerator.generateId(), args);
        addArrayInRepo(array);
    }

    @Override
    public void addNumberInRepo(int id, int[] args) {
        CustomArray array = new CustomArray(id, args);
        addArrayInRepo(array);
    }

    @Override
    public void addListInRepo(List<CustomArray> array) {
        for (CustomArray customArray : array) {
            addArrayInRepo(customArray);
        }
    }
}
