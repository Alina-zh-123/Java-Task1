package com.zhilyuk.task1.parser;

import com.zhilyuk.task1.entity.CustomArray;
import com.zhilyuk.task1.exception.ArrayException;
import java.util.List;

public interface ArrayParser {
    List<int[]> arrayParse(List<String> arraysString) throws ArrayException;
}