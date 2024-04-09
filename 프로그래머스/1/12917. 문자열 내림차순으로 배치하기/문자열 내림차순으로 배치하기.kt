class Solution {
    fun solution(s: String): String {
        val sa = s.toCharArray()
        sa.sortDescending()
        var answer = sa.joinToString("")
        return answer
    }
}