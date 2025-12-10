package com.zhilyuk.task1.repository;

import com.zhilyuk.task1.entity.CustomArray;
import com.zhilyuk.task1.exception.ArrayException;
import com.zhilyuk.task1.specification.ArraySpecification;

import java.util.ArrayList;
import java.util.Comparator;

public interface ArrayRepository {
    CustomArray findById(Long arrayId) throws ArrayException;
    void deleteByID(long arrayId) throws ArrayException;
    ArrayList<CustomArray> find(ArraySpecification specification);
    void sort(Comparator<CustomArray> comparator);
    void add(CustomArray array);
    void remove(CustomArray array);
}
