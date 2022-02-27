package by.yukhnevich.array.repository.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.CustomArrayRepositorySpecification;

public class IdSpecificationRepository implements CustomArrayRepositorySpecification {
    private int id;

    public IdSpecificationRepository(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(CustomArray array) {
        return array.getId() == id;
    }
}
