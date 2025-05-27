import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayDeque

fun main() {
    val reader = System.`in`.bufferedReader()
    val dRow = intArrayOf(1, -1, 0, 0)
    val dCol = intArrayOf(0, 0, 1, -1)
    val comp = Comparator<Pair<Int, Pair<Int, Int>>> { o1, o2 ->
        o1.first.compareTo(o2.first)
    }
    val pq = PriorityQueue<Pair<Int, Pair<Int, Int>>>(comp)
    var size = reader.readLine().toInt()
    var idx = 1
    val answer = buildString {
        while (size != 0) {
            val board = Array(size) {
                reader.readLine().split(" ").map { it.toInt() }
            }
            val visited = Array(size) {
                BooleanArray(size)
            }
            val costMap = Array(size) {
                IntArray(size) { 125 * 125 * 10 }
            }
            pq.offer(board[0][0] to Pair(0, 0))
            costMap[0][0] = board[0][0]
            while (pq.isNotEmpty()) {
                val current = pq.poll()
                if(visited[current.second.first][current.second.second]) continue
                visited[current.second.first][current.second.second] = true
                for (i in 0..3) {
                    val newR = current.second.first + dRow[i]
                    val newC = current.second.second + dCol[i]
                    if (newR !in 0 until size || newC !in 0 until size) continue
                    if (visited[newR][newC]) continue
                    costMap[newR][newC] = costMap[newR][newC].coerceAtMost(current.first + board[newR][newC])
                    pq.offer(costMap[newR][newC] to Pair(newR, newC))
                }
            }
            appendLine("Problem ${idx++}: ${costMap[size - 1][size - 1]}")
            size = reader.readLine().toInt()
        }
    }
    println(answer)
}