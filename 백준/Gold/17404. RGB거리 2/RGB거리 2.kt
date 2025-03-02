const val MAX_VALUE = 1_000_000
fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val colors = Array(num) {
        reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val dp = Array(3) {
        Array(num) {
            IntArray(3)
        }
    }

    var answer = MAX_VALUE
    for (i in 0 until 3) {
        dp[i][0][0] = MAX_VALUE
        dp[i][0][2] = MAX_VALUE
        dp[i][0][1] = MAX_VALUE
        dp[i][0][i] = colors[0][i]

        for (j in 1 until num) {
            for (k in 0 until 3) {
                dp[i][j][k] = when (k) {
                    0 -> colors[j][0] + Math.min(dp[i][j - 1][1], dp[i][j - 1][2])
                    1 -> colors[j][1] + Math.min(dp[i][j - 1][0], dp[i][j - 1][2])
                    2 -> colors[j][2] + Math.min(dp[i][j - 1][0], dp[i][j - 1][1])
                    else -> {0}
                }
            }
        }
        dp[i][num - 1][i] = MAX_VALUE
        val min = dp[i][num - 1].min()
        if(answer > min) answer = min
    }

    println(answer)
}