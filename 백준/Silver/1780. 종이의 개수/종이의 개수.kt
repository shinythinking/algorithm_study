fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val board = Array(num) {
        reader.readLine().split(" ").map(String::toInt).toIntArray()
    }
    val ans = IntArray(3)
    fun conquer(from: Pair<Int, Int>, size: Int): Boolean {
        val (r, c) = from
        val origin = board[r][c]
        for (i in r until r + size) {
            for (j in c until c + size) {
                if (origin != board[i][j]) return false
            }
        }
        return true
    }

    fun divide(from: Pair<Int, Int>, size: Int) {
        val dif = size / 3
        if (conquer(from, size)) {
            when(board[from.first][from.second]) {
                -1 -> ans[0]++
                0 -> ans[1]++
                1 -> ans[2]++
            }
        } else {
            val (r, c) = from
            repeat(3){ i ->
                repeat(3) { j ->
                    val newR = r + i * dif
                    val newC = c + j * dif
                    divide(newR to newC, dif)
                }
            }
        }
    }

    divide(0 to 0, num)
    println(ans.joinToString("\n"))
}