class Solution {
    public int rob(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        return Math.max(robInterval(nums, 0, nums.length - 2), robInterval(nums, 1, nums.length - 1));
    }
    
    private int robInterval(int[] nums, int start, int end) {
        int cur = 0;
        int dp1 = 0;
        int dp2 = 0;
        
        for (int i = end; i >= start; i--) {
            cur = Math.max(dp1, nums[i] + dp2);
            dp2 = dp1;
            dp1 = cur;
        }
        
        return cur;
    }
}