class Solution {
    public static int BinarySearch(int nums[],int target,int s, int e){
        if(s>e)return -1;
        int mid = s+(e-s)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]>target) e = mid-1;
        else if(nums[mid]<target) s = mid+1;
        return BinarySearch(nums,target,s,e);
    }
    public int search(int[] nums, int target) {
        int s=0;
        int e = nums.length-1;
        int ans = BinarySearch(nums,target,s,e);
        return ans;
        
    }
}