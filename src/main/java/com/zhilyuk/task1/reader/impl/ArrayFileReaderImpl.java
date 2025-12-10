package com.zhilyuk.task1.reader.impl;

import com.zhilyuk.task1.exception.ArrayException;
import com.zhilyuk.task1.reader.ArrayFileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class ArrayFileReaderImpl implements ArrayFileReader {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> arrayReadFromFile(String path) throws ArrayException {
        if (path == null || path.isBlank()) {
            logger.error("File path is empty");
            throw new ArrayException("File path is empty!");
        }
        try {
            List<String> arrays = Files.readAllLines(Paths.get(path));
            logger.info("File is read, created {} arrays", arrays.size());
            return arrays;
        } catch (IOException e) {
            logger.error("Read from file error: {}", path, e);
            throw new ArrayException("Read from file error: {}" + path, e);
        }
    }
}
