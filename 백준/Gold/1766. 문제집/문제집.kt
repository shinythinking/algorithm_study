import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (num, condition) = reader.readLine().split(" ").map { it.toInt() }
    val outDegree = Array(num + 1) { mutableListOf<Int>() }
    val inDegree = IntArray(num + 1)
    val pq = PriorityQueue<Int>()
    val answer = mutableListOf<Int>()

    repeat(condition) {
        val (from, to) = reader.readLine().split(" ").map { it.toInt() }
        inDegree[to]++
        outDegree[from].add(to)
    }

    for(i in 1..num) {
        if(inDegree[i] == 0) pq.add(i)
    }

    while(pq.isNotEmpty()) {
        val current = pq.poll()
        answer.add(current)
        for(next in outDegree[current]) {
            inDegree[next]--
            if(inDegree[next] == 0) pq.add(next)
        }
    }

    println(answer.joinToString(" "))
}