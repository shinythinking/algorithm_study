import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (row, col) = reader.readLine()!!.split(" ").map { it.toInt() }
    val board = Array(row) {
        reader.readLine().split(" ").map { it == "1" }
    }
    val visited = Array(row) {
        BooleanArray(col)
    }
    var cnt = 0
    var max = 0
    var curSize = 0
    val queue = LinkedList<Pair<Int, Int>>()
    val dR = intArrayOf(1, -1, 0, 0)
    val dC = intArrayOf(0, 0, 1, -1)
    for (i in 0 until row) {
        for (j in 0 until col) {
            if (visited[i][j]) continue
            if (!board[i][j]) {
                visited[i][j] = true
                continue
            }
            queue.add(Pair(i, j))
            curSize = 1
            cnt++
            visited[i][j] = true
            while (queue.isNotEmpty()) {
                val start = queue.removeFirst()
                for (k in 0..3) {
                    val nextR = start.first + dR[k]
                    val nextC = start.second + dC[k]
                    if (nextR !in 0 until row || nextC !in 0 until col) continue
                    if (visited[nextR][nextC]) continue
                    visited[nextR][nextC] = true
                    if(board[nextR][nextC]) {
                        curSize++
                        queue.addLast(Pair(nextR, nextC))
                    }
                }
            }
            max = max.coerceAtLeast(curSize)
        }
    }
    println("$cnt\n$max")
}