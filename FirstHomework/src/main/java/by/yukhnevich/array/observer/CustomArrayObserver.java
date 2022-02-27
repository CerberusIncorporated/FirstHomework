package by.yukhnevich.array.observer;

public interface CustomArrayObserver {
    void clearParameters(CustomArrayEvent event);

    void changedParameters(CustomArrayEvent event);
}
