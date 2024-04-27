import java.util.*

class Solution {
    fun solution(s: String): IntArray {
        val strArr = s.replace("{", "").dropLast(2).split("},").sortedBy{ it.length }
        val lhs = LinkedHashSet<Int>()
        
        for(str in strArr){
            for(d in str.split(',').map{it.toInt()}){
                lhs.add(d)
            }
        }
        
        return lhs.toIntArray()
    }
}