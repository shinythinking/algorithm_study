class Solution {
    fun solution(s: String): Int {
        var answer: Int = 1
        
        var idx = 0
        var same = 1
        var diff = 0
        var target = s[0]
        for(i in 1..s.lastIndex){
            if(s[i] == target){
                same++
            } else {
                diff++
            }
            
            if(same == diff){
                answer++
                same = 0
                diff = 0
                target = s.getOrNull(i + 1) ?: '.'
            }
        }
        if(target == '.')
            answer--
        
        return answer
    }
}