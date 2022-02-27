package by.yukhnevich.array.observer;

import by.yukhnevich.array.entity.AbstractArray;
import by.yukhnevich.array.entity.CustomArray;

import java.util.EventObject;

public class CustomArrayEvent extends EventObject {
    public CustomArrayEvent(AbstractArray source) {
        super(source);
    }

    @Override
    public CustomArray getSource() {
        return (CustomArray) super.getSource();
    }
}
