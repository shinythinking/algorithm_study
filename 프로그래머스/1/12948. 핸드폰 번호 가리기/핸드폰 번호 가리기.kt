class Solution {
    fun solution(phone_number: String): String {
        val len = phone_number.length
        val lastIdx = len - 1
        var answer = "*".repeat(len - 4) + phone_number.substring(lastIdx - 3..lastIdx)
        return answer
    }
}