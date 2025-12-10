package com.zhilyuk.task1.parser.impl;

import com.zhilyuk.task1.entity.CustomArray;
import com.zhilyuk.task1.parser.ArrayParser;
import com.zhilyuk.task1.validator.impl.ArrayValidatorImpl;
import com.zhilyuk.task1.factory.impl.ArrayFactoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.zhilyuk.task1.exception.ArrayException;
import java.util.ArrayList;
import java.util.List;

public class ArrayParserImpl implements ArrayParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String DELIMITERS_REGEX = "[,;\\-\\s]";

    @Override
    public List<int[]> arrayParse(List<String> arraysString) throws ArrayException {
        List<int[]> arrays = new ArrayList<>();
        ArrayValidatorImpl validator = new ArrayValidatorImpl();
        for (String line : arraysString) {
            if (validator.arrayValidateString(line)) {
                String[] arrayString = line.strip().split(DELIMITERS_REGEX);
                int[] intArray = new int[arrayString.length];

                for (int i = 0; i < arrayString.length; i++) {
                    intArray[i] = Integer.parseInt(arrayString[i]);
                }
                arrays.add(intArray);
            } else {
                logger.error("String is invalid for parsing: {}", line);
                throw new ArrayException("String is invalid for parsing!");
            }
        }
        logger.info("Created array of arrays: {}", arrays);
        return arrays;
    }
}


