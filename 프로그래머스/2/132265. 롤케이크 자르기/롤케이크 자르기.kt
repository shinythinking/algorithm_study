import java.util.*

class Solution {
    fun solution(topping: IntArray): Int {
        var hsL = HashMap<Int, Int>()
        var hsR = HashMap<Int, Int>()
        
        for(d in topping)
            hsR[d] = hsR.getOrDefault(d, 0) + 1
        
        var typeR = hsR.size
        
        var answer: Int = 0
        for(i in topping){
            hsL[i] = hsL.getOrDefault(i, 0) + 1
            hsR[i] = hsR.getOrDefault(i, 0) - 1
            if(hsR.getOrDefault(i, -1) == 0)
                typeR--
            if(typeR == hsL.size)
                answer++
        }
        
        return answer
    }
}