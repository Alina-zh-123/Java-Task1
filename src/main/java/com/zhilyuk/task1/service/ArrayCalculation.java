package com.zhilyuk.task1.service;

import com.zhilyuk.task1.entity.CustomArray;
import java.util.OptionalInt;

public interface ArrayCalculation {
    OptionalInt findMaxInArray(CustomArray array);
    OptionalInt findMinInArray(CustomArray array);
    OptionalInt findSumArray(CustomArray array);
    OptionalInt avgArray(CustomArray array);
}
