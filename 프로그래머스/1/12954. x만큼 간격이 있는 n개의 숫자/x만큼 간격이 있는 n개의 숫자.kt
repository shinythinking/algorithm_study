class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = longArrayOf()
        var temp = x.toLong()
        repeat(n){
            answer += temp
            temp += x.toLong()
        }
        return answer
    }
}