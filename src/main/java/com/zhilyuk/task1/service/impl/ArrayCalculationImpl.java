package com.zhilyuk.task1.service.impl;

import com.zhilyuk.task1.entity.CustomArray;
import com.zhilyuk.task1.service.ArrayCalculation;
import java.util.OptionalInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCalculationImpl implements ArrayCalculation {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public OptionalInt findMaxInArray(CustomArray array) {
        if (array.getSize() == 0) {
            logger.warn("Array is empty, max not found");
            return OptionalInt.empty();
        }
        int max = array.getElement(0);
        for (int i = 1; i < array.getSize(); i++) {
            if (array.getElement(i) > max) {
                max = array.getElement(i);
            }
        }
        logger.info("Found max in array: {}", max);
        return OptionalInt.of(max);
    }

    @Override
    public OptionalInt findMinInArray(CustomArray array) {
        if (array.getSize() == 0) {
            logger.warn("Array is empty, min not found");
            return OptionalInt.empty();
        }
        int min = array.getElement(0);
        for (int i = 1; i < array.getSize(); i++) {
            if (array.getElement(i) < min) {
                min = array.getElement(i);
            }
        }
        logger.info("Found min in array: {}", min);
        return OptionalInt.of(min);
    }

    @Override
    public OptionalInt findSumArray(CustomArray array) {
        if (array.getSize() == 0) {
            logger.warn("Array is empty, sum not found");
            return OptionalInt.empty();
        }
        int sum = 0;
        for (int i = 0; i < array.getSize(); i++) {
            sum += array.getElement(i);
        }
        logger.info("Found sum of array: {}", sum);
        return OptionalInt.of(sum);
    }

    @Override
    public OptionalInt avgArray(CustomArray array) {
        if (array.getSize() == 0) {
            logger.warn("Array is empty, avg not found");
            return OptionalInt.empty();
        }
        int sum = findSumArray(array).orElse(0);
        int avg = sum / array.getSize();
        logger.info("Found avg of array: {}", avg);
        return OptionalInt.of(avg);
    }
}
