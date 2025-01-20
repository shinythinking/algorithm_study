fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val dp = LongArray(num + 1)
    dp[0] = 1
    dp[2] = 1
    for (i in 4..num step(2)) {
        for(j in 0..i - 2 step 2){
            dp[i] += (dp[j] * dp[i - j - 2])
            dp[i] %= 987654321L
        }
    }

    println(dp[num])
}