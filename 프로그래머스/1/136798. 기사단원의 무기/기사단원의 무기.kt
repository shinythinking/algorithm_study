import java.util.*

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        val divisors = IntArray(number + 1) { 2 }
        for(i in 2 .. number / 2){
            var idx = 2
            while (true){
                val mul = i * idx
                if(mul > number)
                    break
                divisors[mul]++
                idx++
            }
        }
        divisors[0] = 0
        divisors[1] = 1
        val answer = divisors
            .map{ if(it > limit) power else it }
            .sum()
        
        
        return answer
    }
}