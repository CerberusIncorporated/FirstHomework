package by.yukhnevich.array.entity;

import by.yukhnevich.array.observer.CustomArrayEvent;
import by.yukhnevich.array.observer.CustomArrayObservable;
import by.yukhnevich.array.observer.CustomArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class AbstractArray implements CustomArrayObservable {
    private static final Logger LOGGER = LogManager.getLogger();
    private CustomArrayObserver observers;


    @Override
    public void attach(CustomArrayObserver observer) {
        if (observers == null) {
            observers = observer;
        } else {
            LOGGER.error("observer already used");
        }
    }

    @Override
    public void detach(CustomArrayObserver observer) {
        if (observers != null) {
            observers = null;
        } else {
            LOGGER.error("observer not used");
        }
    }

    @Override
    public void notifyObservers() {
        CustomArrayEvent event = new CustomArrayEvent(this);
        if (observers != null) {
            observers.clearParameters(event);
            observers.updateAvgValue(event);
            observers.updateSumValue(event);
            observers.updateMaxValue(event);
            observers.updateMinValue(event);
        }
    }
}
