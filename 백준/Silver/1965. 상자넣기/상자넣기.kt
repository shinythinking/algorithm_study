fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val nums = reader.readLine().split(" ").map { it.toInt() }
    val dp = mutableListOf<Int>()
    dp.add(nums[0])
    fun upperBound(list: List<Int>, target: Int): Int {
        var lo = 0
        var hi = list.size
        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (list[mid] < target) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }

    for (i in 1 until nums.size) {
        val idx = upperBound(dp, nums[i])
        if (idx >= dp.size) dp.add(nums[i])
        else dp[idx] = nums[i]
    }
    println(dp.size)
}