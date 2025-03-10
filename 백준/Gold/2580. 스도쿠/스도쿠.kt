fun main() {
    val reader = System.`in`.bufferedReader()
    val board = Array(9) {
        reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val rows = Array(9) { BooleanArray(10) }
    val cols = Array(9) { BooleanArray(10) }
    val grids = Array(9) { BooleanArray(10) }

    for(i in 0..8){
        for(j in 0..8) {
            if(board[i][j] != 0) {
                rows[i][board[i][j]] = true
                cols[j][board[i][j]] = true
                grids[i / 3 * 3 + j / 3][board[i][j]] = true
            }
        }
    }

    fun nextPair(r: Int, c: Int): Pair<Int, Int> {
        return if(c == 8){
            r + 1 to 0
        } else {
            r to c + 1
        }
    }
    fun dfs(r: Int, c: Int): Boolean {
        if(r == 9){
            return true
        }

        val next = nextPair(r, c)
        if(board[r][c] != 0){
            return dfs(next.first, next.second)
        }

        for(i in 1..9){
            if(rows[r][i] || cols[c][i] || grids[r / 3 * 3 + c / 3][i]) continue

            board[r][c] = i
            rows[r][i] = true
            cols[c][i] = true
            grids[r / 3 * 3 + c / 3][i] = true

            if(dfs(next.first, next.second)){
                return true
            }
            board[r][c] = 0
            rows[r][i] = false
            cols[c][i] = false
            grids[r / 3 * 3 + c / 3][i] = false
        }

        return false
    }

    dfs(0, 0)
    println(board.joinToString("\n") { it.joinToString(" ") })
}