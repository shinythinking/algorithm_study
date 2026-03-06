class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        fun cal(time: Long, times: IntArray): Long {
            var ans = 0L
            for (t in times) {
                ans += time/t
            }
            return ans
        }

        fun lowerbound(target: Long, end: Long, times: IntArray): Long {
            var left = 0L
            var right = end + 1
            while(left < right) {
                val mid = left + (right - left)/2
                if(target <= cal(mid, times)){
                    right = mid
                } else {
                    left = mid + 1
                }
            }
            return left
        }
        val maxTime = times.maxOrNull()!!.toLong() * n
        return lowerbound(n.toLong(), maxTime, times)
    }
}