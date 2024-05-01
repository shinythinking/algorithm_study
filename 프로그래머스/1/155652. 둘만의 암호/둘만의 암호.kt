class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        var alphabet = "abcdefghijklmnopqrstuvwxyz"
        for(ch in skip){
            alphabet = alphabet.replace(ch.toString(), "")
        }
        

        var answer = ""
        for(ch in s){
            var idx = alphabet.indexOf(ch) + index
            while(idx >= alphabet.length)
                idx -= alphabet.length
            
            answer += alphabet[idx]
        }
        return answer
    }
}