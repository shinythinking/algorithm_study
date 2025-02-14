fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val target = (1 shl 10) - 1
    val mod = 1_000_000_000
    val dp = Array(num + 1) {
        Array(10) {
            Array(target + 1) { 0 }
        }
    }

    for (i in 1..9) {
        dp[1][i][1 shl i] = 1
    }

    for (i in 2..num) {
        for (j in 0..9) {
            for (k in 0..target) {
                val bit = k or (1 shl j)
                when (j) {
                    0 -> {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % mod
                    }

                    9 -> {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % mod
                    }

                    else -> {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k] + dp[i - 1][j - 1][k]) % mod
                    }
                }
            }
        }
    }
    var answer = 0L
    for(i in 0 until 10) {
        answer = (answer + dp[num][i][target]) % mod
    }
    println(answer)
}