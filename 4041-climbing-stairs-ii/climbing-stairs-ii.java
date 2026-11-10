class Solution {
    public int climbStairs(int n, int[] costs) {
        int [] dp = new int[n+1];
        dp[0] = 0 ;
        for(int i = n-1 ; i >= 0 ;i--){
            int cost = Integer.MAX_VALUE ;
            int j = i + 1 ;
            if(j <= n){
                cost = costs[j-1] + (j-i)*(j-i) + dp[j];
            }
            j = i + 2 ;
            if( j <= n){
                cost = Math.min(cost, costs[j-1] + (j-i)*(j-i) + dp[j]) ;
            }
            j = i + 3 ;
            if(j <= n){
                cost = Math.min(cost, costs[j-1] + (j-i)*(j-i) + dp[j]) ;
            }
            dp[i] = cost ;
        }
        return dp[0] ; 
    }
}