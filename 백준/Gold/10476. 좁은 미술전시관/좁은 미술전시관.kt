fun main() {
    val reader = System.`in`.bufferedReader()
    val (n, k) = reader.readLine().split(' ').map { it.toInt() }
    val gallery = Array(1){ listOf(0, 0) } + Array(n) {
        reader.readLine().split(' ').map { it.toInt() }
    }

    val dp = Array(n + 1) { Array(n + 1) { IntArray(3) } }
    dp[1][1][0] = gallery[1][1]
    dp[1][1][1] = gallery[1][0]
    dp[1][0][2] = gallery[1][0] + gallery[1][1]
    for (i in 2 .. n) {
        for(j in 0 .. k) {
            if(j >= 1){
                dp[i][j][0] = dp[i - 1][j - 1][0].coerceAtLeast(dp[i - 1][j - 1][2]) + gallery[i][1]
                dp[i][j][1] = dp[i - 1][j - 1][1].coerceAtLeast(dp[i - 1][j - 1][2]) + gallery[i][0]
            }
            if(i != j)
                dp[i][j][2] = dp[i - 1][j][0].coerceAtLeast(dp[i - 1][j][1]).coerceAtLeast(dp[i - 1][j][2]) + gallery[i][1] + gallery[i][0]
        }
    }
    reader.readLine()

    println(dp[n][k][0].coerceAtLeast(dp[n][k][1]).coerceAtLeast(dp[n][k][2]))
}