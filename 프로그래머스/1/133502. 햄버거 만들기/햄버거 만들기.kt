import java.util.*

class Solution {
    fun solution(ingredient: IntArray): Int {
        var answer = 0
        var nextStack = ArrayDeque<Int>()
        nextStack.push(1)
        var next = 1
        for(d in ingredient){
            if(next == 4 && d == 1){
                answer++
                if(nextStack.isEmpty())
                    next = 1
                else
                    next = nextStack.pop()
                continue
            }
            
            if(d == next){
                next++
            } else {
                if(d == 1){
                    nextStack.push(next)
                    next = 2
                }
                else{
                    nextStack.clear()
                    nextStack.push(1)
                    next = 1
                }       
            }
        }
        return answer
    }
}