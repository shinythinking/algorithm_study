class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        for(i in 2 until n){
            if(n % i == 1){
                return i
            }
        }
        return answer
    }
}