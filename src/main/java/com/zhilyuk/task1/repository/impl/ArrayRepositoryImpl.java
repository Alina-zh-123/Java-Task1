package com.zhilyuk.task1.repository.impl;

import com.zhilyuk.task1.entity.CustomArray;
import com.zhilyuk.task1.exception.ArrayException;
import com.zhilyuk.task1.repository.ArrayRepository;
import com.zhilyuk.task1.specification.ArraySpecification;
import com.zhilyuk.task1.warehouse.impl.WarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayRepositoryImpl implements ArrayRepository {
    private static final Logger logger = LogManager.getLogger();
    private static final ArrayRepositoryImpl INSTANCE = new ArrayRepositoryImpl();
    private final ArrayList<CustomArray> arrays = new ArrayList<>();

    public static ArrayRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public CustomArray findById(Long arrayId) throws ArrayException {
        CustomArray res = null;
        for (CustomArray array : arrays) {
            if (array.getArrayId() == arrayId) {
                res = array;
                break;
            }
        }
        if (res != null) {
            logger.info("Found array by id {}", arrayId);
            return res;
        } else {
            throw new ArrayException("No array with such id!");
        }
    }

    @Override
    public void deleteByID(long arrayId) throws ArrayException {
        CustomArray res = null;
        for (CustomArray array : arrays) {
            if (array.getArrayId() == arrayId) {
                res = array;
                break;
            }
        }
        if (res != null) {
            arrays.remove(res);
            logger.info("Deleted array by id {}", arrayId);
        } else {
            throw new ArrayException("No array with such id!");
        }
    }

    @Override
    public ArrayList<CustomArray> find(ArraySpecification specification) {
        ArrayList<CustomArray> resArray = new ArrayList<>();
        for (CustomArray array : arrays) {
            if (specification.specify(array)) {
                resArray.add(array);
            }
        }
        logger.info("Found arrays by specification {}", specification);
        return resArray;
    }

    @Override
    public void sort(Comparator<CustomArray> comparator) {
        arrays.sort(comparator);
        logger.info("Sorted arrays by comparator {}", comparator);
    }

    @Override
    public void add(CustomArray array) {
        arrays.add(array);
        logger.info("Added array {}", array);
    }

    @Override
    public void remove(CustomArray array) {
        arrays.remove(array);
        logger.info("Deleted array {}", array);
    }
}
