fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val nums = reader.readLine().split(" ").map { it.toInt() }
    val query = reader.readLine().toInt()
    val dp = Array(num) {
        BooleanArray(num)
    }
    for (i in 0 until num) {
        dp[i][i] = true
        var prev = dp[i][i]
        var nextR = i - 1
        var nextC = i + 1
        while (nextR in 0 until num && nextC in 0 until num) {
            dp[nextR][nextC] = (nums[nextC] == nums[nextR]) && prev
            prev = dp[nextR][nextC]
            nextC++
            nextR--
        }
    }

    for (i in 0 until num - 1) {
        dp[i][i + 1] = nums[i] == nums[i + 1]
        var prev = dp[i][i + 1]
        var nextR = i - 1
        var nextC = i + 2
        while (nextR in 0 until num && nextC in 0 until num) {
            dp[nextR][nextC] = (nums[nextC] == nums[nextR]) && prev
            prev = dp[nextR][nextC]
            nextC++
            nextR--
        }
    }
    val answer = buildString {
        repeat(query) {
            val (from, to) = reader.readLine().split(" ").map { it.toInt() - 1 }
            appendLine(if(dp[from][to]) 1 else 0)
        }
    }

    println(answer)
}