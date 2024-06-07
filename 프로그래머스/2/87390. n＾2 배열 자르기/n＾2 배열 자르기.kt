import java.util.*
class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val answer = IntArray((right - left).toInt() + 1)
        val m = n.toLong()
        
        for(i in answer.indices){
            val temp = left + i.toLong()
            answer[i] = Math.max((temp / m) ,(temp % m)).toInt() + 1
        }
        return answer
    }
}