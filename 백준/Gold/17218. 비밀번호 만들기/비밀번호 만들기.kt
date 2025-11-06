fun main() {

    val input1 = "0" + readln()
    val input2 = "0" + readln()
    val dp = Array(input1.length + 1) {
        IntArray(input2.length + 1) { 0 }
    }

    for (i in 1..input1.lastIndex) {
        for (j in 1..input2.lastIndex) {
            if (input1[i] == input2[j]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }

    var row = input1.lastIndex
    var col = input2.lastIndex
    var cnt =dp[row][col]
    val answer = CharArray(cnt)
    while(cnt != 0) {
        while(cnt == dp[row][col - 1])
            col --

        while(cnt == dp[row - 1][col])
            row --
        answer[--cnt] = input1[row]
        row--
        col--
    }

    println(answer.joinToString(""))
}