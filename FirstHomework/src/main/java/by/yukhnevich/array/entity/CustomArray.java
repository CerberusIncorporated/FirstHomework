package by.yukhnevich.array.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class CustomArray extends AbstractArray {
    private static final Logger LOGGER = LogManager.getLogger();
    private int[] array;
    private int id;

    public CustomArray(int id, int... array) {
        this.id = id;
        this.array = array;
        LOGGER.log(Level.INFO, "Array initialized successfully");
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public int getId() {
        return id;
    }

    public void setArray(int[] array) {
        this.array = array;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "CustomArray{" + "array=" + Arrays.toString(array) + '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return getId() == that.getId() && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = result * 31 + Arrays.hashCode(array);
        return result;
    }


}
