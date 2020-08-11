package base.sort.heap_sort;

public class Main {
    /*
     * Title:
     * Link :
     * Label: [""]
     * Diff : Hard
     * Desc :
     *
     * 执行用时 :  ms
     * 内存消耗 :  MB
     * */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void buildHeap(int[] arr, int n) {
        int lastNode = n - 1;
        int parent = (lastNode - 1) / 2;
        int i;
        for (i = parent; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private void heapSort(int[] arr, int n) {
        buildHeap(arr, n);
        int i;
        for (i = n - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        if (i >= n) {
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && arr[c1] > arr[max]) {
            max = c1;
        }
        if (c2 < n && arr[c2] > arr[max]) {
            max = c2;
        }
        if (max != i) {
            swap(arr, max, i);
            heapify(arr, n, max);
        }
    }

    public void sort(int[] arr) {
        heapSort(arr, arr.length);
    }


    public static void main(String[] args) {
        Main ss = new Main();
        int[] arr = new int[]{8, 9, 1, 4, 3, 3, 2, 6, 6, 7};
        ss.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
