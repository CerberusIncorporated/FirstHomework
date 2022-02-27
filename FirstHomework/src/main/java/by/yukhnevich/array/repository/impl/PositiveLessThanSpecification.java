package by.yukhnevich.array.repository.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.repository.CustomArrayRepositorySpecification;
import by.yukhnevich.array.service.impl.ArrayServiceImplement;

public class PositiveLessThanSpecification implements CustomArrayRepositorySpecification {
    private int countPositive;

    public PositiveLessThanSpecification(int countPositive) {
        this.countPositive = countPositive;
    }

    @Override
    public boolean specify(CustomArray array) {
        ArrayServiceImplement action = new ArrayServiceImplement();
        return action.findPositiveNumbers(array) < countPositive;
    }
}
