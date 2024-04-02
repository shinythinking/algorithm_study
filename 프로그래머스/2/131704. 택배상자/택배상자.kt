import java.util.*

class Solution {
    fun solution(order: IntArray): Int {
        var stack: ArrayDeque<Int> = ArrayDeque(order.size)
        var conveyor = 1
        var answer = 0

        for(orderNum in order){
            if(orderNum == stack.peek() ?: 0){
                stack.pop()
                answer++
                continue
            } else if(conveyor > orderNum){
                break
            }

            while(conveyor <= orderNum) {

                if(conveyor != orderNum){
                    stack.push(conveyor)
                    conveyor++
                } else {
                    answer++
                    conveyor++
                    break
                }
            }

        }
        
        return answer
    }
}