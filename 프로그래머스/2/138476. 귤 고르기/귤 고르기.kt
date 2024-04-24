import java.util.*

class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var lhm = LinkedHashMap<Int, Int>()
        for(i in tangerine){
            lhm[i] = lhm.getOrDefault(i, 0) + 1
        }
        var sortedValues = lhm.values.sortedDescending()
        
        var temp = k
        var idx = 0
        while(temp > 0){
            temp -= sortedValues[idx++]
        }
        var answer: Int = idx
        return answer
    }
}