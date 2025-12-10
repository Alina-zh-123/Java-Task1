package com.zhilyuk.task1;

import com.zhilyuk.task1.entity.CustomArray;
import com.zhilyuk.task1.service.impl.ArrayCalculationImpl;
import com.zhilyuk.task1.service.impl.ArraySortImpl;
import com.zhilyuk.task1.parser.impl.ArrayParserImpl;
import com.zhilyuk.task1.exception.ArrayException;
import java.util.OptionalInt;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.zhilyuk.task1.reader.impl.ArrayFileReaderImpl;

public class ArrayServiceImplTest {

    @Test
    public void testArrayReadFromFile() {
        try {
            ArrayFileReaderImpl reader = new ArrayFileReaderImpl();
            List<String> arraysRead = reader.arrayReadFromFile("data/input.txt");
            try {
                ArrayParserImpl parser = new ArrayParserImpl();
                List<int[]> arrays = parser.arrayParse(arraysRead);

                assertFalse(arrays.isEmpty());
            } catch (ArrayException e) {
                fail("File parse error: " + e.getMessage());
            }
        } catch (ArrayException e) {
            fail("File read error: " + e.getMessage());
        }
    }

    @Test
    public void testFindMaxInArray() {
        int expected = 5;
        CustomArray array = new CustomArray(new int[]{1, 5, 4, 3, 5});
        ArrayCalculationImpl calcImpl = new ArrayCalculationImpl();

        OptionalInt max = calcImpl.findMaxInArray(array);
        assertTrue(max.isPresent(), "No value");
        int actual = max.getAsInt();
        assertEquals(expected, actual, String.format("Max must be %d, but found %d", expected, actual));
    }

    @Test
    public void testFindMinInArray() {
        int expected = 1;
        CustomArray array = new CustomArray(new int[]{1, 5, 4, 3, 5});
        ArrayCalculationImpl calcImpl = new ArrayCalculationImpl();

        OptionalInt min = calcImpl.findMinInArray(array);
        assertTrue(min.isPresent(), "No value");
        int actual = min.getAsInt();
        assertEquals(expected, actual, String.format("Min must be %d, but found %d", expected, actual));

    }

    @Test
    public void testSumArray() {
        int expected = -8;
        CustomArray array = new CustomArray(new int[]{1, 1, -10});
        ArrayCalculationImpl calcImpl = new ArrayCalculationImpl();

        OptionalInt sum = calcImpl.findSumArray(array);
        assertTrue(sum.isPresent(), "No value");
        int actual = sum.getAsInt();
        assertEquals(expected, actual, String.format("Sum must be %d, but found %d", expected, actual));

    }

    @Test
    public void testMergeSort() {
        CustomArray expected = new CustomArray(new int[]{-4, 0, 2, 5});
        CustomArray array = new CustomArray(new int[]{5, 0, 2, -4});
        ArraySortImpl sortImpl = new ArraySortImpl();

        sortImpl.mergeSort(array, 0, array.getSize() - 1);
        assertEquals(expected, array);
    }

    @Test
    public void testSelectionSort() {
        CustomArray expected = new CustomArray(new int[]{-4, 0, 2, 5});
        CustomArray array = new CustomArray(new int[]{5, 0, 2, -4});
        ArraySortImpl sortImpl = new ArraySortImpl();

        sortImpl.selectionSort(array);
        assertEquals(expected, array);
    }
}
