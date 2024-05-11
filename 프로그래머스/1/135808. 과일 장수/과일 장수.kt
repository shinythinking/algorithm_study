class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        
        val sorted = score.sortedDescending()
        var lastIdx = m - 1
        while(lastIdx <= score.lastIndex){
            answer += sorted[lastIdx] * m
            lastIdx += m
        }
        
        return answer
    }
}