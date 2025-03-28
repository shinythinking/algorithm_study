
fun main() {
    val reader = System.`in`.bufferedReader()
    val input1 = "0" + reader.readLine()
    val input2 = "0" + reader.readLine()
    val len1 = input1.length - 1
    val len2 = input2.length - 1
    val dp = Array(len1 + 1) {
        IntArray(len2 + 1)
    }

    for (i in 1..len1) {
        for (j in 1..len2) {
            dp[i][j] = if (input1[i] == input2[j])
                dp[i - 1][j - 1] + 1
            else
                Math.max(dp[i][j - 1], dp[i - 1][j])
        }
    }
    if (dp[len1][len2] == 0) {
        println(dp[len1][len2])
    } else {
        var curR = len1
        var target = dp[len1][len2]
        val answer = buildString {
            while (target > 0) {
                val idx = dp[curR].indexOf(target)
                if (dp[curR - 1][idx] < target && dp[curR][idx - 1] < target) {
                    append(input1[curR])
                    curR--
                    target--
                } else {
                    curR--
                }
            }
        }.reversed()
        println("${dp[len1][len2]}\n$answer")
    }
}