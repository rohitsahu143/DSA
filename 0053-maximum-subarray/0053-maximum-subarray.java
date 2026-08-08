class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int csum = nums[0];
        int maxsum = nums[0];
        for(int i=1;i<n;i++){
            csum = Math.max(nums[i],csum+nums[i]);
            maxsum = Math.max(csum,maxsum);
        }
        return maxsum;
    }
}