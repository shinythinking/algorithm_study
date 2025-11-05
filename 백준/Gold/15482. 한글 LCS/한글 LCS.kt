fun main() {
    val input1 = "가" + readln()
    val input2 = "하" + readln()
    val dp = Array(input1.length){
        IntArray(input2.length) { 0 }
    }

    for(i in 1..dp.lastIndex) {
        for(j in 1..dp[0].lastIndex) {
            if(input1[i] == input2[j])
                dp[i][j] = dp[i-1][j-1] + 1
            else
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j])
        }
    }
    println(dp[dp.lastIndex][dp[0].lastIndex])
}