import java.util.*

class Solution {
    fun solution(s: String): Int {
        val pairMap = mapOf('(' to ')','[' to ']','{' to '}')
        val stack = ArrayDeque<Char>()
        var answer = 0
        
        if(s.length % 2 != 0){
            return 0
        }
        
        // 1. 살펴볼 index를 의미
        // 2. 
        var currentIdx = 0
        var startIdx = 0
        
        while(true){
            
            if(currentIdx >= s.length || currentIdx < startIdx){
                break
            }
            startIdx = currentIdx
            while(true){
                if(pairMap.contains(s[currentIdx])){
                    stack.push(s[currentIdx])
                } else {
                    if(stack.isEmpty()){
                        break
                    } else {
                        if(pairMap[stack.peek()]!! == s[currentIdx]){
                            stack.pop()
                        } else {
                            break
                        }
                    }
                }
                currentIdx ++
                currentIdx %= s.length
                if(currentIdx == startIdx){
                    answer++
                    break
                }
            }
            stack.clear()
            currentIdx++
        }

        return answer
        
    }
}