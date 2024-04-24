class Solution {
    fun solution(n: Int): Long {
        var dp = longArrayOf(1L, 2L, 3L)
        for(i in 3..n){
            dp[2] = (dp[1] + dp[0]) % 1234567
            dp[0] = dp[1]
            dp[1] = dp[2]
        }
        return when(n){
            1 -> dp[0]
            2 -> dp[1]
            else -> dp[2]
        }
    }
}