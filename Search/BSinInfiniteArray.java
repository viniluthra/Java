package Search;
//Suppose you have a sorted array of infinite numbers, how would you search an element in the array?
//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
public class BSinInfiniteArray {
    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target = 10;
        System.out.println(findTarget(nums,target));
    }
    public static int findTarget(int[] nums , int target) {
        int start =0,end=1;
        while(target > nums[end]) {
            int newStart = end+1;
            end = end+ (end-start+1)*2;
            start = newStart;
        }
        return binarySearch(nums,target,start,end);
    }
    public static int binarySearch(int[] nums , int target, int start, int end) {
        while (start<= end) {
            int mid = start + (end-start)/2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}
