import java.util.*

class Solution {
    fun solution(elements: IntArray): Int {
        var dp = Array(elements.size) { IntArray(elements.size) }
        var set = mutableSetOf<Int>()
        for((i, d) in elements.withIndex()){
            dp[0][i] = d
            set.add(dp[0][i])
        }
        
        for(i in 1..dp.lastIndex){
            for(j in 1..dp[0].lastIndex){
                dp[i][j] = dp[i - 1][j - 1] + dp[0][j]
                set.add(dp[i][j])
            }
            dp[i][0] = dp[i - 1][dp[0].lastIndex] + dp[0][0]
            set.add(dp[i][0])
        }
        var answer: Int = set.size
        return answer
    }
}