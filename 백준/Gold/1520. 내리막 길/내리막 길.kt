fun main() {
    val reader = System.`in`.bufferedReader()
    val (row, col) = reader.readLine().split(" ").map { it.toInt() }
    val board = Array(row) {
        reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val dp = Array(row) {
        IntArray(col) { -1 }
    }

    val dRow = arrayOf(0, 0, -1, 1)
    val dCol = arrayOf(-1, 1, 0, 0)

    fun dfs1(r: Int, c: Int): Int {
        if (r == row - 1 && c == col - 1) return 1
        if (dp[r][c] != -1) return dp[r][c]

        dp[r][c] = 0
        for (i in 0 until 4) {
            val newR = r + dRow[i]
            val newC = c + dCol[i]
            if (newR !in 0 until row || newC !in 0 until col) continue
            if (board[newR][newC] >= board[r][c]) continue
            dp[r][c] = dp[r][c] + dfs1(newR, newC)
        }
        return dp[r][c]
    }

    dfs1(0, 0)
    println(dp[0][0])
}