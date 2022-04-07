package by.yukhnevich.compositechain.service.impl;

import by.yukhnevich.compositechain.comparator.ComponentSizeComparator;
import by.yukhnevich.compositechain.entity.ComplexTextComponent;
import by.yukhnevich.compositechain.entity.TextComponent;
import by.yukhnevich.compositechain.entity.TextComponentType;
import by.yukhnevich.compositechain.exception.CustomTextException;
import by.yukhnevich.compositechain.service.CustomTextSorter;

public class CustomTextSorterImpl implements CustomTextSorter {

    private static final ComponentSizeComparator comparator = new ComponentSizeComparator();

    @Override
    public void sort(TextComponent component) throws CustomTextException {
        if (!(component instanceof ComplexTextComponent)) {
            throw new CustomTextException("Invalid TextComponent type: "
                    + component.getClass().getName() + ". Require ComplexTextComponent.");
        }

        ComplexTextComponent text = (ComplexTextComponent) component;
        if (text.getType() != TextComponentType.TEXT) {
            throw new CustomTextException("Invalid ComplexTextComponent type: "
                    + text.getType() + ". Require TEXT type.");
        }

        text.getComponents().sort(comparator);
    }
}
