package base.sort.quick_sort.sort3ways;

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

    private void sort(int[] arr) {
        quickSort3Ways(arr, 0, arr.length - 1);
    }

    private void quickSort3Ways(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int l = low + 1, r = high;
        int lowV = arr[low];
        int crr = low + 1;
        while (crr <= r) {
            int crrV = arr[crr];
            if (crrV < lowV) {
                swap(arr, crr, l);
                l++;
                crr++;
            } else if (crr > lowV) {
                swap(arr, crr, r);
                r--;
            } else {
                crr++;
            }
        }
        swap(arr, low, l - 1);
        quickSort3Ways(arr, low, l - 1);
        quickSort3Ways(arr, r + 1, high);
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
