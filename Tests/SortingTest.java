import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortingTest {
    public Integer[] array = {5, 3, 8, 6, 2, 7, 4, 1};
    public Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};

    @Test
    public void testMergeSort() {

        MergeSort algorithm = new MergeSort();

        algorithm.sort(array);

        assertArrayEquals(array, expected);

    }

    @Test
    public void testSelectionSort() {

        SelectionSort algorithm = new SelectionSort();

        algorithm.sort(array);

        assertArrayEquals(array, expected);

    }

    @Test
    public void testQuickSort() {

        Quick algorithm = new Quick();

        algorithm.sort(array);

        assertArrayEquals(array, expected);

    }
}
