package Sorting;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {3,2,5,1,4};
        System.out.println(missingNumber(arr));
    }

        static int missingNumber(int[] nums) {
            int i=0;
            while(i<nums.length) {
                int correct = nums[i];
                if(nums[i] < nums.length && nums[i] != nums[correct]) {
                    swap(nums,i,correct);
                }
                else {
                    i++;
                }
            }
            for(i=0;i<nums.length;i++) {
                if(nums[i] != i) {
                    return i;
                }

            }
            return nums.length;
        }
        static void swap(int[] nums, int first, int second) {
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;
        }
    }

