package com.zhilyuk.task1.warehouse.impl;

import com.zhilyuk.task1.entity.CustomArrayData;
import com.zhilyuk.task1.warehouse.Warehouse;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WarehouseImpl implements Warehouse {
    private static final Logger logger = LogManager.getLogger();
    private static final WarehouseImpl INSTANCE = new WarehouseImpl();
    private final Map<Long, CustomArrayData> data = new HashMap<>();

    public static WarehouseImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void putCustomArray(long arrayId, CustomArrayData arrayData) {
        data.put(arrayId, arrayData);
        logger.info("New array data added by id {}", arrayId);
    }
}
