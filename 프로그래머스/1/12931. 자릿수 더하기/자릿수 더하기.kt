class Solution {
    fun solution(n: Int): Int {
        var answer = 0

        var input = n
        while(input != 0){
            answer += input % 10
            input /= 10
        }

        return answer
    }
}