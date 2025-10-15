fun main() {
    val tc = readln().toInt()
    var sum = 0
    val ans = buildString {
        repeat(tc) {
            val n = readln().toInt()
            val l = readln().split(" ").map { it.toInt() }
            val dp = IntArray(n) { 0 }
            var p = 0 to 0
            var globalMax = l[0]
            dp[0] = l[0]
            for (i in 1 until n) {
                dp[i] = Math.max(dp[i - 1] + l[i], l[i])
                if (globalMax < dp[i]) {
                    var tmp = l[i]
                    var idx = i
                    while (tmp != dp[i]) {
                        tmp += l[--idx]
                    }
                    p = idx to i
                    globalMax = dp[i]

                } else if (globalMax == dp[i]) {
                    var tmp = l[i]
                    var idx = i
                    while (tmp != dp[i]) {
                        tmp += l[--idx]
                    }
                    if (i - idx < p.second - p.first) {
                        p = idx to i
                    }
                }
            }
            sum += globalMax
            appendLine("${p.first + 1} ${p.second + 1}")
        }
    }
    println(sum)
    println(ans)
}