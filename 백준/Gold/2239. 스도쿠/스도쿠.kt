fun main() {
    val reader = System.`in`.bufferedReader()
    val rows = Array(9){
        BooleanArray(10)
    }
    val cols = Array(9){
        BooleanArray(10)
    }
    val grids = Array(9){
        BooleanArray(10)
    }

    val board = Array(9) {
        val str = reader.readLine()
        str.map{ it - '0' }.toIntArray()
    }
    for(i in 0 until 9) {
        for(j in 0 until 9) {
            if(board[i][j] == 0) continue
            rows[i][board[i][j]] = true
            cols[j][board[i][j]] = true
            grids[i / 3 * 3 + j / 3][board[i][j]] = true
        }
    }

    fun getNextIdx(i: Int, j: Int): Pair<Int, Int> {
        return if(j == 8){
            Pair(i + 1, 0)
        } else {
            Pair(i, j + 1)
        }
    }

    fun dfs(i: Int, j: Int): Boolean {
        if(i == 9){
            return true
        }
        if(board[i][j] != 0){
            val next = getNextIdx(i, j)
            return dfs(next.first, next.second)
        }
        for(k in 1..9) {
            if(!rows[i][k] && !cols[j][k] && !grids[i / 3 * 3 + j / 3][k]) {
                board[i][j] = k
                rows[i][k] = true
                cols[j][k] = true
                grids[i / 3 * 3 + j / 3][k] = true
                val next = getNextIdx(i, j)
                if(dfs(next.first, next.second)){
                    return true
                }
                board[i][j] = 0
                rows[i][k] = false
                cols[j][k] = false
                grids[i / 3 * 3 + j / 3][k] = false
            }
        }
        return false
    }

    dfs(0,0)
    println(board.joinToString("\n") { it.joinToString("") })

}