class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var bottle = n
        val input = a
        val output = b
        while(bottle >= input){
            val remainder = bottle % input
            bottle = bottle / input
            answer += bottle * output
            bottle *= output
            bottle += remainder
            
        }
        return answer
    }
}