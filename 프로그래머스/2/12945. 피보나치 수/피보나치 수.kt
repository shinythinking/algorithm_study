class Solution {
    fun solution(n: Int): Int {
        var dp = IntArray(3)
        dp[0] = 0
        dp[1] = 1
        for(i in 2..n){
            dp[2] = (dp[0] + dp[1]) % 1234567
            dp[0] = dp[1]
            dp[1] = dp[2]
        }
        
        return dp[2]
    }
}