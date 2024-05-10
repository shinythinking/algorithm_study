class Solution {
    fun solution(n: Long): Long {
        val square = Math.sqrt(n.toDouble())
        var answer: Long = 0
        if(square == Math.ceil(square)){
            answer = ((square + 1) * (square + 1)).toLong()
        } else
            answer = -1L
        
        return answer
    }
}