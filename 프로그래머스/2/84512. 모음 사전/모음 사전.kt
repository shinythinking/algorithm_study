class Solution {
    fun solution(word: String): Int {
        val dict = mapOf<Char, Int>(
            'A' to 0,
            'E' to 1,
            'I' to 2,
            'O' to 3,
            'U' to 4
        )
        var answer = word.length
        
        val weight = listOf(781, 156, 31, 6, 1)
        for((i, ch) in word.withIndex()){
            answer += weight[i] * dict[ch]!!
        }
        return answer
    }
}