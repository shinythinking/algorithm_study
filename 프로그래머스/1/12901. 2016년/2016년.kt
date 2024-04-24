class Solution {
    fun solution(a: Int, b: Int): String {
        val month = intArrayOf(0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335)
        var days = month[a - 1] + b
        var answer = when(days % 7){
            0 -> "THU"
            1 -> "FRI"
            2 -> "SAT"
            3 -> "SUN"
            4 -> "MON"
            5 -> "TUE"
            else -> "WED"
        }
        return answer
    }
}