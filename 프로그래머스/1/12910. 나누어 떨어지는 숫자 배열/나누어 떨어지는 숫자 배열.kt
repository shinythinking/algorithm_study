class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = intArrayOf()
        for(num in arr){
            if(num % divisor == 0)
                answer += num
        }
        if(answer.size == 0){
            answer += -1
        } else {
            answer.sort()
        }
        return answer
    }
}