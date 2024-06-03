class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer: Long = 0L
        val limit = d.toDouble() / k.toDouble() 
        val limitSquare = (limit * limit)
        
        for(i in 0..limit.toInt()){
            val iSquare = i.toLong() * i.toLong()
            answer += Math.sqrt(limitSquare - iSquare).toLong() + 1
        }
        
        return answer
    }
}