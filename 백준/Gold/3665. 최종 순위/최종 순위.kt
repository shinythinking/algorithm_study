import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val testcase = reader.readLine().toInt()
    repeat(testcase) {
        val num = reader.readLine().toInt()
        val rank = reader.readLine().split(" ").map { it.toInt() }
        val change = reader.readLine().toInt()
        val graph = Array(num + 1) { mutableListOf<Int>() }
        val inDegree = IntArray(num + 1)
        val queue = LinkedList<Int>()
        val answer = mutableListOf<Int>()

        for (i in 0 until num) {
            for (j in i + 1 until num) {
                graph[rank[i]].add(rank[j])
                inDegree[rank[j]]++
            }
        }

        repeat(change) {
            var (from, to) = reader.readLine()!!.split(" ").map { it.toInt() }
            if (graph[from].contains(to)) {
                val temp = from
                from = to
                to = temp
            }

            graph[from].add(to)
            graph[to].remove(from)
            inDegree[to]++
            inDegree[from]--
        }

        for (i in 1..num) {
            if (inDegree[i] == 0) queue.add(i)
        }

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            answer.add(node)
            if (queue.isNotEmpty()) {
                println("?")
                return@repeat
            }
            for (next in graph[node]) {
                inDegree[next]--
                if (inDegree[next] == 0) queue.add(next)
            }
        }

        if (inDegree.any { it != 0 }) {
            println("IMPOSSIBLE")
        } else {
            println(answer.joinToString(" "))
        }
    }
}