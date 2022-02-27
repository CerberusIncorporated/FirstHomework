package by.yukhnevich.array.repository.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.CustomArrayRepositorySpecification;
import by.yukhnevich.array.service.impl.ArrayServiceImplement;

import java.util.OptionalInt;

public class MaxSpecificationRepository implements CustomArrayRepositorySpecification {

    private int max;

    public MaxSpecificationRepository(int max) {
        this.max = max;
    }

    @Override
    public boolean specify(CustomArray array) {
        ArrayServiceImplement action = new ArrayServiceImplement();
        OptionalInt arrayEntityMin = action.findMaxNumber(array);
        if (arrayEntityMin.isPresent()) {
            return arrayEntityMin.getAsInt() == max;
        } else {
            return false;
        }
    }
}
