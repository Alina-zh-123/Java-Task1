package com.zhilyuk.task1.observer.impl;

import com.zhilyuk.task1.entity.CustomArray;
import com.zhilyuk.task1.entity.CustomArrayData;
import com.zhilyuk.task1.exception.ArrayException;
import com.zhilyuk.task1.observer.CustomArrayObserver;
import com.zhilyuk.task1.service.impl.ArrayCalculationImpl;
import com.zhilyuk.task1.warehouse.impl.WarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalInt;

public class CustomArrayObserverImpl implements CustomArrayObserver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void onCustomArrayChange(CustomArray array) {
        long arrayId = array.getArrayId();
        ArrayCalculationImpl calculation = new ArrayCalculationImpl();

        OptionalInt maxOpt = calculation.findMaxInArray(array);
        int max = maxOpt.orElse(0);
        OptionalInt minOpt = calculation.findMinInArray(array);
        int min = minOpt.orElse(0);
        OptionalInt sumOpt = calculation.findSumArray(array);
        int sum = sumOpt.orElse(0);

        CustomArrayData arrayData = new CustomArrayData(max, min, sum);
        logger.info("Array {} updated with max={}, min={}, sum={}", arrayId, max, min, sum);

        WarehouseImpl warehouse = new WarehouseImpl();
        warehouse.putCustomArray(arrayId, arrayData);
    }
}
