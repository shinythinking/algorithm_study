class Solution {
    fun solution(s: String, n: Int): String {
        var answer = ""
        for(ch in s){
            if(ch == 32.toChar())
                answer += ch
            else if(ch >= 'A' && ch <= 'Z'){
                if(ch + n > 'Z'){
                    answer += 'A' + ((ch + n) - 'Z' - 1) 
                } else {
                    answer += ch + n
                }
            } else {
                if(ch + n > 'z'){
                    answer += 'a' + ((ch + n) - 'z' - 1) 
                } else {
                    answer += ch + n
                }
            }
        }
        return answer
    }
}