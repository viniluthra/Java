package Search;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] nums = {12,9,8,5,3,1,0};
        int target = 100;
        System.out.println(binarySearch(nums,target));
    }

    public static int binarySearch(int[] nums, int target) {
        int start =0, end= nums.length-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                end = mid-1;
            } else if (target < nums[mid]) {
                start = mid+1;
            }
        }
        return -1;
    }
}
