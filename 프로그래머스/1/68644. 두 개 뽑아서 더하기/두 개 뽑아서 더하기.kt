import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer = mutableSetOf<Int>()
        
        for(i in numbers.indices){
            for(j in i + 1 .. numbers.lastIndex){
                answer.add(numbers[i] + numbers[j])
            }
        }
        
        return answer.sorted().toIntArray()
    }
}