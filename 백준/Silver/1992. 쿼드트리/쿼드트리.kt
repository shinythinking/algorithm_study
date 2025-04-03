fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val board = Array(num) {
        reader.readLine().map { it - '0' }.toIntArray()
    }

    fun conquer(from: Pair<Int, Int>, size: Int): Boolean {
        val (r, c) = from
        val standard = board[r][c]
        for (i in r until r + size) {
            for (j in c until c + size) {
                if (board[i][j] != standard) return false
            }
        }

        return true
    }

    fun divide(from: Pair<Int, Int>, size: Int): String {
        val (r, c) = from
        return if (conquer(from, size)) board[r][c].toString()
        else {
            buildString {
                append("(")
                val dif = size / 2
                repeat(2) { i ->
                    repeat(2) { j ->
                        val newR = r + i * dif
                        val newC = c + j * dif
                        append(divide(newR to newC, dif))
                    }
                }
                append(")")
            }
        }
    }

    println(divide(0 to 0, num))
}