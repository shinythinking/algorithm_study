class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        val la = a.toLong()
        val lb = b.toLong()
        answer = (Math.abs(la - lb) + 1) * (la + lb) / 2
        
        return answer
    }
}