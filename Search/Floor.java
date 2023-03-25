package Search;

public class Floor {
    public static void main(String[] args) {
        int[] arr = {1,3,8,9,12,14,18} ;
        int target = 0;
        System.out.println(binarySearch(arr,target));
    }
    public static int binarySearch(int[] nums, int target) {
        int start =0,end =nums.length-1;
        if(target < nums[0]) {
            return -1;
        }
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(target == nums[mid]) {
                return nums[mid];
            } else if (target < nums[mid]) {
                end = mid-1;
            } else if (target > nums[mid]) {
                start = mid+1;
            }
        }
        return nums[end];
    }
}
