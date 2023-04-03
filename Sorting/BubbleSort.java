package Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        //bubbleSort(arr);
        System.out.println(arr.toString());
    }
    public static void bubbleSort(int[] arr) {
        boolean swapped = false;
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr.length-1;j++) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if (swapped)
                break;
        }
    }
}
