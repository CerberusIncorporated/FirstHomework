package by.yukhnevich.array.service;

import by.yukhnevich.array.entity.CustomArray;

import java.util.List;

public interface CustomRepositoryService {
    void addArrayInRepo(CustomArray array);

    void addNumberInRepo(int... args);

    void addNumberInRepo(int id, int[] args);

    void addListInRepo(List<CustomArray> array);
}
