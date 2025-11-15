fun main() {
    val (to, from) = readln().split(" ").map{it.toInt()}
    if(to == from) {
        println(1)
        return
    }
    val dif = Math.abs(to-from) - 1
    val dp = Array(dif + 1) {
        LongArray(dif + 1)
    }
    dp[0][0] = 1
    for(i in 1..dif) {
        dp[i][0] = 1
        for(j in 1..i - 1) {
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
        }
        dp[i][i] = dp[i][i - 1]
    }
    println(dp.last().sum())
}