import java.util.*

class Solution {
    fun solution(s: String): Int {
        var answer = 0
        val parentMap = mapOf('(' to ')','[' to ']','{' to '}')
        val stack = ArrayDeque<Char>()
        
        if(s.length % 2 != 0){
            return 0
        }
        var idx = -1
        var startIdx = 0
        
        while(true){
            idx++
            if(idx >= s.length || idx < startIdx){
                break
            }
            startIdx = idx
            while(true){
                if(parentMap.contains(s[idx])){
                    stack.push(s[idx])
                } else {
                    if(stack.isEmpty()){
                        break
                    } else {
                        if(parentMap[stack.peek()]!! == s[idx]){
                            stack.pop()
                        } else {
                            break
                        }
                    }
                }
                idx ++
                idx %= s.length
                if(idx == startIdx){
                    answer++
                    break
                }
            }
            stack.clear()
        }

        return answer
        
    }
}