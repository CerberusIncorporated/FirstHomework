package by.yukhnevich.compositechain.comparator;

import by.yukhnevich.compositechain.entity.TextComponent;

import java.util.Comparator;

public class ComponentSizeComparator implements Comparator<TextComponent> {

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return o1.size() - o2.size();
    }
}
