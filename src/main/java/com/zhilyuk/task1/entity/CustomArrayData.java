package com.zhilyuk.task1.entity;

import com.zhilyuk.task1.service.impl.ArrayCalculationImpl.*;
import java.util.Objects;

public class CustomArrayData {
    private int max;
    private int min;
    private int sum;

    public CustomArrayData(int max, int min, int sum) {
        this.max = max;
        this.min = min;
        this.sum = sum;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("max=").append(max)
                .append(", min=").append(min)
                .append(", sum=").append(sum);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomArrayData arrayData = (CustomArrayData) o;
        return max == arrayData.max && min == arrayData.min && sum == arrayData.sum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, min, sum);
    }
}
