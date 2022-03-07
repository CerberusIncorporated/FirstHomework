package by.yukhnevich.array.repository;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.exception.CustomArrayException;

import java.util.Comparator;
import java.util.List;

public interface CustomArrayRepository {

    boolean addArray(CustomArray arrayEntity);

    boolean addAllArrays(List<CustomArray> arrayEntities);

    boolean removeArray(CustomArray arrayEntity);

    boolean removeAllArrays(List<CustomArray> arrayEntities);

    CustomArray get(int index);

    CustomArray set(int index, CustomArray arrayEntity);

    List<CustomArray> query(CustomArrayRepositorySpecification specification);

    List<CustomArray> sort(Comparator<? super CustomArray> comparator);
}
