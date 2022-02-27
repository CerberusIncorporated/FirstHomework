package by.yukhnevich.array.repository.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.CustomArrayRepositorySpecification;

public class LengthSpecificationRepository implements CustomArrayRepositorySpecification {
    private int length;

    public LengthSpecificationRepository(int length) {
        this.length = length;
    }

    @Override
    public boolean specify(CustomArray array) {
        return array.getArray().length == length;
    }
}
