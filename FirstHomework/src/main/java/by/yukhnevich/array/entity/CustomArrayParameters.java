package by.yukhnevich.array.entity;

import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayParameters {
    private OptionalInt max;
    private OptionalInt min;
    private OptionalInt sum;
    private OptionalDouble average;

    public CustomArrayParameters(OptionalInt max, OptionalInt min, OptionalInt sum, OptionalDouble average) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.average = average;
    }

    public OptionalInt getMax() {
        return max;
    }

    public void setMax(OptionalInt max) {
        this.max = max;
    }

    public OptionalInt getMin() {
        return min;
    }

    public void setMin(OptionalInt min) {
        this.min = min;
    }

    public OptionalInt getSum() {
        return sum;
    }

    public void setSum(OptionalInt sum) {
        this.sum = sum;
    }

    public OptionalDouble getAverage() {
        return average;
    }

    public void setAverage(OptionalDouble average) {
        this.average = average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArrayParameters that = (CustomArrayParameters) o;
        return Objects.equals(max, that.max)
                && Objects.equals(min, that.min)
                && Objects.equals(sum, that.sum)
                && Objects.equals(average, that.average);
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, min, sum, average);
    }

    @Override
    public String toString() {
        return "CustomArrayParameters{" +
                "max=" + max +
                ", min=" + min +
                ", sum=" + sum +
                ", average=" + average +
                '}';
    }
}