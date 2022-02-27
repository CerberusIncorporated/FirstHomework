package by.yukhnevich.array.observer;

public interface CustomArrayObserver {
    void clearParameters(CustomArrayEvent event);

    void updateMinValue(CustomArrayEvent event);

    void updateMaxValue(CustomArrayEvent event);

    void updateAvgValue(CustomArrayEvent event);

    void updateSumValue(CustomArrayEvent event);
}
