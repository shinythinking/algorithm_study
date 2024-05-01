class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        val skipList = skip.map{ it.toChar() }
        val alphabet = ('a'..'z').filter{ it !in skipList}

        var answer = ""
        for(ch in s){
            var idx = alphabet.indexOf(ch) + index
            while(idx >= alphabet.size)
                idx -= alphabet.size
            
            answer += alphabet[idx]
        }
        return answer
    }
}