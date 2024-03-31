class Solution {
    fun solution(s: String): String {
                var answer = ""

        var len = s.length / 2
        if(s.length % 2 == 0){
            answer = s.substring(len - 1 .. len )
        } else {
            answer = s.substring(len .. len)
        }
        return answer
    }
}