import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val reader = System.`in`.bufferedReader()
    val (c, r) = reader.readLine()!!.split(" ").map { it.toInt() }
    val board = Array(r) {
        reader.readLine().map { it - '0' }.toIntArray()
    }
    val visited = Array(board.size) {
        BooleanArray(board[0].size)
    }
    val deque = LinkedList<Pair<Int, Int>>()
    val dRow = intArrayOf(0, 0, 1, -1)
    val dCol = intArrayOf(1, -1, 0, 0)
    deque.addFirst(0 to 0)

    while (deque.isNotEmpty()) {
        val current = deque.removeFirst()
        for (i in 0..3) {
            val newR = current.first + dRow[i]
            val newC = current.second + dCol[i]
            if (newR !in 0 until r || newC !in 0 until c) continue
            if (visited[newR][newC]) continue
            visited[newR][newC] = true
            if (board[newR][newC] == 1) {
                deque.addLast(newR to newC)
                board[newR][newC] = board[current.first][current.second] + 1
            } else {
                deque.addFirst(newR to newC)
                board[newR][newC] = board[current.first][current.second]
            }
        }
    }
    println(board[r - 1][c - 1])
}