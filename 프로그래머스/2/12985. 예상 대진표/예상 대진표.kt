class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
 
        var ap = a
        var bp = b
        while(ap != bp){
            answer ++
            ap = (ap + 1) / 2
            bp = (bp + 1) / 2
        }

        return answer
    }
}