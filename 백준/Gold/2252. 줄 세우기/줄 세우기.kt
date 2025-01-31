import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (num, comparison) = reader.readLine()!!.split(" ").map { it.toInt() }
    val graph = Array(num + 1) { mutableListOf<Int>() }
    val queue = LinkedList<Int>()
    val inDegree = IntArray(num + 1)

    repeat(comparison) {
        val (from, to) = reader.readLine()!!.split(" ").map { it.toInt() }
        graph[from].add(to)
        inDegree[to]++
    }

    for(i in 1..num) {
        if(inDegree[i] == 0) {
            queue.add(i)
        }
    }

    val answer = buildString {
        while(queue.isNotEmpty()) {
            val node = queue.removeFirst()
            for(to in graph[node]) {
                inDegree[to]--
                if(inDegree[to] == 0) {
                    queue.add(to)
                }
            }

            append("$node ")
        }
    }
    println(answer)
}