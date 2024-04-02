import java.util.*

class Solution {
    fun solution(order: IntArray): Int {
        var answer = 0
        var conveyor: ArrayDeque<Int> = ArrayDeque(order.size)
        var stack: ArrayDeque<Int> = ArrayDeque(order.size)
        for(i in order.size downTo 1){
            conveyor.push(i)
        }
        
        for(orderNum in order){
            if(orderNum == stack.peek() ?: 0){
                stack.pop()
                answer++
                continue 
            } else if(conveyor.isEmpty()){
                break
            }
            
            while(!conveyor.isEmpty()) {
                val popped = conveyor.pop()
                if(popped != orderNum){
                    stack.push(popped)
                } else {
                    answer++
                    break
                }    
            }
            
        }
        
        return answer
    }
}