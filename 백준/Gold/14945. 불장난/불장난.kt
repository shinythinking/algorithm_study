fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()

    val dp = Array(num + 1) { IntArray(num + 1) }
    dp[2][1] = 1
    for(i in 3..num) {
        for( j in 1 until i) {
            dp[i][j] = (dp[i - 1][j] * 2 + dp[i - 1][j + 1] + dp[i - 1][j - 1]) % 10_007
        }
    }

    println((dp[num].sum() * 2) % 10_007)
}