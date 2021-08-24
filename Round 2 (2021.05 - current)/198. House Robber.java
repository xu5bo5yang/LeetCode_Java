class Solution {
    public int rob(int[] nums) {
        int cur = 0;
        int dp1 = 0;
        int dp2 = 0;
        
        if (nums.length < 1) {
            return 0;
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            cur = Math.max(dp1, nums[i] + dp2);
            dp2 = dp1;
            dp1 = cur;
        }
        
        return cur;
    }
}