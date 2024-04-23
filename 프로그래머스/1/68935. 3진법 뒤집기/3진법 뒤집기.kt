class Solution {
    fun solution(n: Int): Int {
        var reversed = ""
        var temp = n
        while(temp >= 3){
            reversed += (temp % 3).toString()
            temp /= 3
            println(reversed)
        }
        reversed += temp.toString()
        var idx = reversed.length - 1
        var idx2 = 0
        var answer = 0
        println(reversed)
        while(idx >= 0){
            answer += Math.pow(3.0, idx.toDouble()).toInt() * (reversed[idx2] - '0')
            idx--
            idx2++
            println(answer)
        }
        
        return answer
    }
}