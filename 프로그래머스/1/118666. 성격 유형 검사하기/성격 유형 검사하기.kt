class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: CharArray = charArrayOf('R', 'C', 'J', 'A')
        val charMap = mutableMapOf<Char, Int>()
        
        for((i, choice) in choices.withIndex()){
            if(choice in 1..3){
                charMap[survey[i][0]] = charMap.getOrDefault(survey[i][0], 0) + (4 - choice)
            } else if (choice in 5..7){
                charMap[survey[i][1]] = charMap.getOrDefault(survey[i][1], 0) + (choice - 4)
            }
        }
        
        val couples = arrayOf(
            charArrayOf('R', 'T'),
            charArrayOf('C', 'F'),
            charArrayOf('J', 'M'),
            charArrayOf('A', 'N')
        )
        for(i in 0..3){
            if(charMap.getOrDefault(couples[i][0], 0) < charMap.getOrDefault(couples[i][1], 0)){
                answer[i] = couples[i][1]
            }
        }
        return answer.joinToString("")
    }
}