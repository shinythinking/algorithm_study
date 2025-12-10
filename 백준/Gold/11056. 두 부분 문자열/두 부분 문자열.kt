fun main() {
    val input1 = readln()
    val input2 = readln()

    val dp = Array(input1.length + 1){
        IntArray(input2.length + 1){0}
    }

    for(i in 1..dp.lastIndex) {
        for(j in 1..dp[0].lastIndex) {
            if(input1[i - 1] == input2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }

    println(input1.length + input2.length - dp[input1.length][input2.length])

}