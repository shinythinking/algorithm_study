fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val board = Array(n) {
        br.readLine().split(" ").map{it.toInt()}
    }
    val dp = Array(n){IntArray(n){0}}
    val dRow = intArrayOf(0,0,1,-1)
    val dCol = intArrayOf(1,-1,0,0)
    var ans = 0

    fun dfs(r: Int, c:Int): Int {
        if(dp[r][c] != 0) return dp[r][c]

        dp[r][c] = 1
        var max = dp[r][c]

        for(i in 0..3) {
            val nextR = r + dRow[i]
            val nextC = c + dCol[i]
            if(nextR !in 0 until n || nextC !in 0 until n) continue
            //if(dp[nextR][nextC] >= depth) continue
            if(board[r][c] >= board[nextR][nextC]) continue
            max = Math.max(max, dfs(nextR, nextC) + 1)
        }
        dp[r][c] = max
        return dp[r][c]
    }

    for(i in 0 until n) {
        for(j in 0 until n) {
            ans = Math.max(ans, dfs(i, j))
            //println(dp.joinToString("\n"){it.joinToString(separator = " ")})
        }
    }

    println(ans)
}