package by.yukhnevich.array.repository.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.CustomArrayRepositorySpecification;
import by.yukhnevich.array.service.impl.ArrayServiceImplement;

import java.util.OptionalInt;

public class MinSpecificationRepository implements CustomArrayRepositorySpecification {
    private int min;

    public MinSpecificationRepository(int min) {
        this.min = min;
    }

    @Override
    public boolean specify(CustomArray array) {
        ArrayServiceImplement action = new ArrayServiceImplement();
        OptionalInt arrayEntityMin = action.findMinNumber(array);
        if (arrayEntityMin.isPresent()) {
            return arrayEntityMin.getAsInt() == min;
        } else {
            return false;
        }
    }
}
