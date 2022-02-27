package by.yukhnevich.array.observer.impl;

import by.yukhnevich.array.entity.CustomArray;
import by.yukhnevich.array.entity.CustomArrayParameters;
import by.yukhnevich.array.entity.CustomArrayWarehouse;
import by.yukhnevich.array.observer.CustomArrayEvent;
import by.yukhnevich.array.observer.CustomArrayObserver;
import by.yukhnevich.array.service.impl.ArrayServiceStreamImplement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class CustomArrayObserverImplement implements CustomArrayObserver {
    private static final Logger LOGGER = LogManager.getLogger();
    private static CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
    private static ArrayServiceStreamImplement streamImplement = new ArrayServiceStreamImplement();

    @Override
    public void clearParameters(CustomArrayEvent event) {
        CustomArray source = event.getSource();
        int sourceId = source.getId();
        warehouse.clear(sourceId);
        LOGGER.info("All parameters is clear");
    }

    @Override
    public void changedParameters(CustomArrayEvent event) {
        CustomArray array = event.getSource();
        OptionalInt max = streamImplement.findMaxNumber(array);
        OptionalInt min = streamImplement.findMinNumber(array);
        OptionalLong sum = streamImplement.findSumOfArray(array);
        OptionalDouble average = streamImplement.findAverageNumber(array);

        CustomArrayParameters parameters = warehouse.get(array.getId());

        if(parameters==null){
            parameters = new CustomArrayParameters(max, min, sum, average);
            warehouse.put(array.getId(), parameters);
            LOGGER.info("CustomArray " + array.getId() + " parameters added to warehouse");
        }
        parameters.setMax(max);
        parameters.setMin(min);
        parameters.setSum(sum);
        parameters.setAverage(average);

        LOGGER.info("CustomArray " + array.getId() + " parameters updated");
    }

}
