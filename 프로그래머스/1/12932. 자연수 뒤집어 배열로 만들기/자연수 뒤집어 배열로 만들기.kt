class Solution {
    fun solution(n: Long): IntArray {
        var answer = intArrayOf()
        var str = n.toString().reversed()

        for(ch in str){
            answer += ch - '0'
        }
        return answer
    }
}