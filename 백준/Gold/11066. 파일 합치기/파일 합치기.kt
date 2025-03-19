
fun main() {
    val reader = System.`in`.bufferedReader()
    val tc = reader.readLine().toInt()
    val answer = buildString {
        repeat(tc) {
            val num = reader.readLine().toInt()
            val arr = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
            val sums = Array(num) {
                IntArray(num)
            }
            val dp = Array(num) {
                IntArray(num)
            }

            for (i in 0 until num) {
                sums[i][i] = arr[i]
                dp[i][i] = arr[i]
                for (j in i + 1 until num) {
                    sums[i][j] = sums[i][j - 1] + arr[j]
                }
            }

            for (i in 0 until num - 1) {
                dp[i][i + 1] = sums[i][i + 1]
            }

            for (step in 2 until num) {
                for (i in 0 until num) {
                    if (i + step >= num) break
                    var min = Math.min(dp[i][i + step - 1], dp[i + 1][i + step])
                    for (j in i + 1 until i + step - 1) {
                        min = Math.min(min, dp[i][j] + dp[j + 1][i + step])
                    }
                    dp[i][i + step] = min + sums[i][i + step]
                }
            }
            appendLine(dp[0][num - 1])
        }
    }

    println(answer)
}