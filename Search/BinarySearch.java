package Search;

//Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
// If target exists, then return its index. Otherwise, return -1.
//You must write an algorithm with O(log n) runtime complexity.
//https://leetcode.com/problems/binary-search/
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 20;
        System.out.println(binarySearch(nums,target));
    }

    public static int binarySearch(int[] nums , int target) {
        int start =0, end = nums.length-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(target == nums[mid]) {
                return mid;
            } else if(target < nums[mid]) {
                end = mid-1;
            } else if(target > nums[mid]) {
                start = mid+1;
            }
        }
        return -1;
    }
}
