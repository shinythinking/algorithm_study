
import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (v, e, s) = reader.readLine().split(" ").map { it.toInt() }
    val matrix = Array(v + 1) {
        mutableListOf<Int>()
    }
    repeat(e) {
        val (from, to) = reader.readLine().split(" ").map { it.toInt() }
        matrix[from].add(to)
        matrix[to].add(from)
    }
    for (i in 1..v) matrix[i].sortByDescending { it }

    val queue = LinkedList<Int>()
    val visited = Array(v + 1) { false }
    queue.addLast(s)
    visited[s] = true
    val answer = IntArray(v + 1) { 0 }
    var ans = 0
    while (queue.isNotEmpty()) {
        val polled = queue.removeFirst()
        ans++
        answer[polled] = ans
        for (node in matrix[polled]) {
            if (visited[node]) continue
            visited[node] = true
            queue.addLast(node)
        }
    }
    println(answer.drop(1).joinToString("\n"))
}