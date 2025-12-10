package com.zhilyuk.task1.validator.impl;

import com.zhilyuk.task1.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayValidatorImpl implements ArrayValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final String VALID_ARRAY_STRING_REGEX = "^\\s*(-?\\d+\\s*([,;\\-\\s]\\s*\\d+\\s*)*)?$";

    @Override
    public boolean arrayValidateString(String arrayString) {
        logger.debug("Validating string: '{}'", arrayString);

        if (arrayString == null || arrayString.isBlank()) {
            logger.warn("String {} is null or empty", arrayString);
            return false;
        }

        boolean flag = arrayString.matches(VALID_ARRAY_STRING_REGEX);
        logger.info("Validity of string: {}", flag);
        return flag;
    }
}
