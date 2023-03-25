package Search;

import java.util.Arrays;

//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//If target is not found in the array, return [-1, -1].
//
//You must write an algorithm with O(log n) runtime complexity.
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums =  {5,7,7,7,7,7,7,7,8,8,9,10};
        int target =0;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
    public static int[] searchRange(int[] nums , int target) {
        int[] ans = {-1,-1};
        ans[0] = binarySearch(nums,target,true);
        if(ans[0] != -1) {
            ans[1] = binarySearch(nums,target,false);
        }
        return ans;
    }
    public static int binarySearch(int[] nums , int target , boolean searchFirstOccr) {
        int ans=-1;
        int start =0,end = nums.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if (target > nums[mid]) {
                start = mid+1;
            } else if (target < nums[mid]) {
                end = mid-1;
            } else {
                ans=mid;
                if(searchFirstOccr) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }
        return ans;
    }
}
