package by.yukhnevich.compositechain.service;

import by.yukhnevich.compositechain.entity.TextComponent;
import by.yukhnevich.compositechain.exception.CustomTextException;

public interface CustomTextSorter {
    void sort(TextComponent component) throws CustomTextException;
}
