package by.yukhnevich.array.repository.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.CustomArrayRepository;
import by.yukhnevich.array.repository.CustomArrayRepositorySpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomArrayRepositoryImpl implements CustomArrayRepository {
    private List<CustomArray> arrays;
    private static CustomArrayRepositoryImpl instance;

    public CustomArrayRepositoryImpl() {
        arrays = new ArrayList<>();
    }

    public static CustomArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CustomArrayRepositoryImpl();
        }
        return instance;
    }

    @Override
    public boolean addArray(CustomArray array) {
        return arrays.add(array);
    }

    @Override
    public boolean addAllArrays(List<CustomArray> array) {
        return arrays.addAll(array);
    }

    @Override
    public boolean removeArray(CustomArray array) {
        return arrays.remove(array);
    }

    @Override
    public boolean removeAllArrays(List<CustomArray> array) {
        return arrays.removeAll(array);
    }

    @Override
    public CustomArray get(int index) {
        return arrays.get(index);
    }

    @Override
    public CustomArray set(int index, CustomArray array) {
        return arrays.set(index, array);
    }

    @Override
    public List<CustomArray> query(CustomArrayRepositorySpecification specification) {
        return arrays.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomArray> sort(Comparator<? super CustomArray> comparator) {
        return arrays.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

}
