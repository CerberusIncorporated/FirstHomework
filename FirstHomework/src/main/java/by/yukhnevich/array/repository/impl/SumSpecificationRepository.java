package by.yukhnevich.array.repository.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.CustomArrayRepositorySpecification;
import by.yukhnevich.array.service.ArrayService;
import by.yukhnevich.array.service.impl.ArrayServiceImplement;

import java.util.OptionalLong;

public class SumSpecificationRepository implements CustomArrayRepositorySpecification {
    private int sum;

    public SumSpecificationRepository(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean specify(CustomArray array) {
        ArrayService action = new ArrayServiceImplement();
        OptionalLong arraySum = action.findSumOfArray(array);
        if (arraySum.isPresent()) {
            return arraySum.getAsLong() == sum;
        } else {
            return false;
        }
    }
}
