package Search;
//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//You must write an algorithm with O(log n) runtime complexity.
//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,3,8,9,12,14,18} ;
        int target = 10;
        System.out.println(binarySearch(arr,target));
    }
    public static int binarySearch(int[] nums, int target) {
        int start =0,end= nums.length-1;
        while(start<=end) {
            int mid= start + (end-start)/2;
            if(target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}
