class Solution {
    fun solution(arr: IntArray): Double {
        var answer = 0
        for(i in arr){
            answer += i
        }
        
        return answer.toDouble() / arr.size.toDouble()
    }
}