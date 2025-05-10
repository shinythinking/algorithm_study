fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val dp = IntArray(num + 1) { it }
    for(i in 2..num) {
        for(j in 2..num) {
            if(i < j * j) break
            dp[i] = dp[i].coerceAtMost(dp[i - j * j] + 1)
        }
    }
    println(dp[num])
}