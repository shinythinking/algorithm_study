class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 0
        val nums = intArrayOf(1,2,3,4,5,6,7,8,9)
        for(num in nums){
            if(num !in numbers)
                answer += num
        }
        return answer
    }
}