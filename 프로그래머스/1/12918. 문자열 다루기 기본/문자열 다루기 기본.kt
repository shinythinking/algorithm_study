class Solution {
    fun solution(s: String): Boolean {
        var answer = true
        val pattern = Regex("[0-9]*")
        if(s.matches(pattern)){
            if(!(s.length == 4 || s.length == 6))
                answer = false
        } else 
            answer = false
        return answer
    }
}