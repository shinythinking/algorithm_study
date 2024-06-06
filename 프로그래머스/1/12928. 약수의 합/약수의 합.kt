class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        val square = Math.sqrt(n.toDouble()).toInt()
        for(i in 1 .. square){
            if(n % i == 0){
                answer += i
                answer += n / i
            }
        }
        if(square * square == n)
            answer -= square
        
        return answer
    }
}