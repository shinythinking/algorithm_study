class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer = intArrayOf()
        if(arr.size <= 1){
            return intArrayOf(-1)
        } else {
            val minN = arr.minOrNull() ?: 0
            answer = arr.filter{ it != minN }.toIntArray()
        }
        return answer
    }
}