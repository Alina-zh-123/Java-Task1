package com.zhilyuk.task1.specification.impl;

import com.zhilyuk.task1.entity.CustomArray;
import com.zhilyuk.task1.specification.ArraySpecification;

public class ArraySizeSpecification implements ArraySpecification {
    private final int size;

    public ArraySizeSpecification(int size) {
        this.size = size;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        return customArray.getSize() == size;
    }
}
