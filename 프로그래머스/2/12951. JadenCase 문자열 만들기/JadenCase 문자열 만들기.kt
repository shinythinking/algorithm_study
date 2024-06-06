import java.util.*

class Solution {
    fun solution(s: String): String {
        val answer = s.lowercase().toCharArray()
        var idx = 0
        var upperList = mutableListOf<Int>(0)
        for((i, ch) in s.withIndex()){
            if(ch == ' '){
                idx = i
                while(idx <= s.lastIndex){
                    if(s[idx] == ' ')
                        idx++
                    else{
                        upperList.add(idx)
                        break
                    }
                }
            }
        }
        
        for(i in upperList){
            answer[i] = answer[i].uppercaseChar()
        }
        
        return answer.joinToString("")
    }
}