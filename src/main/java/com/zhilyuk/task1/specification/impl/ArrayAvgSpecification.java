package com.zhilyuk.task1.specification.impl;

import com.zhilyuk.task1.entity.CustomArray;
import com.zhilyuk.task1.specification.ArraySpecification;
import com.zhilyuk.task1.service.impl.ArrayCalculationImpl;

public class ArrayAvgSpecification implements ArraySpecification {
    public enum ComparisonType {
        EQUAL,
        GREATER,
        LESS
    }

    private final int avg;
    private final ComparisonType comparisonType;

    public ArrayAvgSpecification(int avg, ComparisonType comparisonType) {
        this.avg = avg;
        this.comparisonType = comparisonType;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        ArrayCalculationImpl calculation = new ArrayCalculationImpl();
        int arrayAvg = calculation.avgArray(customArray).orElse(0);
        switch (comparisonType) {
            case EQUAL:
                return arrayAvg == avg;
            case GREATER:
                return arrayAvg > avg;
            case LESS:
                return arrayAvg < avg;
            default:
                return false;
        }
    }
}
