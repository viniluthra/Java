package Sorting;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.ArrayList;
import java.util.List;

public class FindAllDisappearedNumbers {
    public static void main(String[] args) {
        int[] arr = {1,2};
        List<Integer> ans = findDisappearedNumbers(arr);
        System.out.println(ans);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        while(i<nums.length) {
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]) {
                swap(nums,i,correct);
            } else {
                i++;
            }
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        for(i=0;i<nums.length;i++) {
            if(nums[i] != i+1) {
                numbers.add(i+1);
            }
        }
        return numbers;
    }
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
