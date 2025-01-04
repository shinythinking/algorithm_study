fun main() {
    val (row, col) = readln().split(" ").map { it.toInt() }
    val dp = IntArray(row)
    for(i in 0 until row){
        dp[0] = 1
        dp[i] = 1
        var prev = dp[0]
        for(j in 1 .. i / 2){
            val pprev = dp[j]
            dp[j] = prev + dp[j]
            dp[i - j] = dp[j]
            prev = pprev
        }
    }
    println(dp[col - 1])
}