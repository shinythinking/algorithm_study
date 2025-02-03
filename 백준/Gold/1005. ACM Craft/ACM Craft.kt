import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val testcase = reader.readLine().toInt()
    var idx = -1
    val answer = IntArray(testcase)
    repeat(testcase) {
        idx++
        val (num, condition) = reader.readLine().split(" ").map { it.toInt() }
        val times = intArrayOf(0) + reader.readLine().split(" ").map { it.toInt() }
        val outDegree = Array(num + 1) { mutableListOf<Int>() }
        val inDegree = IntArray(num + 1)
        val queue = LinkedList<Int>()
        val distance = IntArray(num + 1)
        repeat(condition) {
            val (from, to) = reader.readLine()!!.split(" ").map { it.toInt() }
            outDegree[from].add(to)
            inDegree[to]++
        }

        for(i in 1..num) {
            if(inDegree[i] == 0) {
                queue.add(i)
                distance[i] = times[i]
            }
        }
        val target = reader.readLine().toInt()

        while(queue.isNotEmpty()) {
            val node = queue.removeFirst()

            for (next in outDegree[node]) {
                inDegree[next]--
                distance[next] = distance[next].coerceAtLeast(distance[node] + times[next])
                if(inDegree[next] == 0) queue.add(next)
            }
        }
        answer[idx] = distance[target]
    }
    println(answer.joinToString("\n"))
}