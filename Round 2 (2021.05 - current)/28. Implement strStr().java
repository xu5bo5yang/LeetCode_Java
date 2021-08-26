class Solution {
        
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        
        if (needle.length() == 0) {
            return 0;
        }
        
        int len = needle.length();
        
        int[][] dp = new int[len][256];
        dp[0][needle.charAt(0)] = 1;
        
        int shadow = 0;
        
        for (int j = 1; j < len; j++) {
            for (int c = 0; c < 256; c++) {
                dp[j][c] = dp[shadow][c];
            }
            
            dp[j][needle.charAt(j)] = j + 1;
            shadow = dp[shadow][needle.charAt(j)];
        }
        
        int j = 0;
        
        for (int i = 0; i < haystack.length(); i++) {
            j = dp[j][haystack.charAt(i)];
            
            if (j == len) {
                return i - len + 1;
            }
        }
        
        return -1;
    }
}