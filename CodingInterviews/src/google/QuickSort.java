package google;

public class QuickSort {

    public void sort(int[] array, int left, int right) {
        int index = partition(array, left, right);
        if (left < index - 1) {
            sort(array, left, index - 1);
        }
        if (index < right) {
            sort(array, index, right);
        }
    }

    public int partition(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        while (left <= right) {
            // find element on left that should be on right
            while (array[left] < pivot)
                left++;
            // find element on right that should be on left
            while (array[right] > pivot)
                right--;
            if (left < right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left; // array[0...left] < array[left] < array[left... end]
    }

    public void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
