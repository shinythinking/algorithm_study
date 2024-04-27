import java.util.*
class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val closet = mutableMapOf<String, Int>()
        for(arr in clothes){
            val type = arr[1]
            closet[type] = closet.getOrDefault(type, 0) + 1
        }
        
        val valueList = closet.values
        
        var answer = 1
        for(d in valueList){
            answer *= (d + 1)
        }
        answer -- 
        return answer
    }
}