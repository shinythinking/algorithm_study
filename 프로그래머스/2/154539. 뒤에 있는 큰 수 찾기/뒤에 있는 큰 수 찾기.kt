import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = IntArray(numbers.size)
        val stackForNum = ArrayDeque<Int>(numbers.size)
        val stackForIdx = ArrayDeque<Int>(numbers.size)
        
        for((i, number) in numbers.withIndex()){
            while(number > stackForNum.peek() ?: 1_000_001){
                stackForNum.pop()
                answer[stackForIdx.pop()] = number
            }
            stackForNum.push(number)
            stackForIdx.push(i)
        }
        while(stackForIdx.isNotEmpty()){
            answer[stackForIdx.pop()] = -1
        }
        return answer
    }
}