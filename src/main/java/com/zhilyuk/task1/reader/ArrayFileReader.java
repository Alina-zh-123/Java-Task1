package com.zhilyuk.task1.reader;

import com.zhilyuk.task1.exception.ArrayException;
import java.util.List;

public interface ArrayFileReader {
    List<String> arrayReadFromFile(String path) throws ArrayException;
}
