fun main() {
    val reader = System.`in`.bufferedReader()
    val (row, col, k) = reader.readLine().split(" ").map { it.toInt() }
    val board = Array(row){
        reader.readLine().map { it == 'W' }
    }
    val compBoard = Array(2) {
        Array(row){
            IntArray(col)
        }
    }

    for(i in 0 until row) {
        var tmp = i % 2 ==0
        for(j in 0 until col) {
            compBoard[0][i][j] = if (tmp == board[i][j]) 0 else 1
            compBoard[1][i][j] = if(tmp != board[i][j]) 0 else 1
            tmp = !tmp
        }
    }

    fun getPrefixSum() {
        for(i in 1 until col) {
            compBoard[0][0][i] += compBoard[0][0][i - 1]
            compBoard[1][0][i] += compBoard[1][0][i - 1]
        }
        for(i in 1 until row) {
            compBoard[0][i][0] += compBoard[0][i - 1][0]
            compBoard[1][i][0] += compBoard[1][i - 1][0]
        }

        for(i in 1 until row) {
            for (j in 1 until col) {
                compBoard[0][i][j] += compBoard[0][i][j - 1] + compBoard[0][i - 1][j] - compBoard[0][i - 1][j - 1]
                compBoard[1][i][j] += compBoard[1][i][j - 1] + compBoard[1][i - 1][j] - compBoard[1][i - 1][j - 1]
            }
        }
    }

    getPrefixSum()

    fun calcPrefixSum(row: Int, col: Int): Int {
        val total = compBoard[0][row][col]
        val top = if(row >= k) compBoard[0][row - k][col] else 0
        val left = if(col >= k) compBoard[0][row][col - k] else 0
        val topLeft = if(row >= k && col >= k) compBoard[0][row - k][col - k] else 0
        val total1 = compBoard[1][row][col]
        val top1 = if(row >= k) compBoard[1][row - k][col] else 0
        val left1 = if(col >= k) compBoard[1][row][col - k] else 0
        val topLeft1 = if(row >= k && col >= k) compBoard[1][row - k][col - k] else 0

        val sum = total - left - top + topLeft
        val sum1 = total1 - left1 - top1 + topLeft1

        return Math.min(sum, sum1)
    }

    var answer = Int.MAX_VALUE
    for(i in k - 1 until row) {
        for(j in k - 1 until col) {
            answer = Math.min(answer, calcPrefixSum(i, j))
        }
    }

    println(answer)
}