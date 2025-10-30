fun main() {
    val num = readln().toInt()
    val dp = Array(num + 1) {
        IntArray(num + 1) { 0 }
    }
    val matrix = Array(1) { 0 to 0 } + Array(num) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        n to m
    }


    for (dif in 1 until num) {
        for (from in 1..num - dif) {
            val to = from + dif
            var min = Int.MAX_VALUE
            for (mid in 0 until to - from) {
                val tmp = dp[from][from + mid] + dp[from + mid + 1][to] + matrix[from].first * matrix[from + mid + 1].first * matrix[to].second
                if (tmp < min) min = tmp

            }
            dp[from][to] = min
        }
    }

    println(dp[1][num])
}