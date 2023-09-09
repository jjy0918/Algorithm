class Solution {
    private long[] dp = new long[20001];
    public long solution(int n) {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        return func(n);
    }
    
    private long func(int n) {
        if(dp[n] == 0) {
            return dp[n] = (func(n-1) + func(n-2)) % 1234567;
        }
        
        return dp[n];
    }
}

