import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (singer, pd) = reader.readLine().split(" ").map { it.toInt() }
    val outDegree = Array(singer + 1) {
        mutableListOf<Int>()
    }
    val inDegree = IntArray(singer + 1)
    val queue = ArrayDeque<Int>()
    val answer = mutableListOf<Int>()

    repeat(pd) {
        val input = reader.readLine().split(" ").map { it.toInt() }
        val num = input[0]
        val singers = input.drop(1)

        for(i in 0 until singers.lastIndex) {
            val from = singers[i]
            val to = singers[i + 1]

            outDegree[from].add(to)
            inDegree[to]++
        }
    }

    for(i in 1 .. inDegree.lastIndex) {
        if(inDegree[i] == 0) {
            queue.add(i)
        }
    }

    while(queue.isNotEmpty()) {
        val current = queue.removeFirst()
        answer.add(current)

        for(next in outDegree[current]) {
            inDegree[next]--

            if(inDegree[next] == 0) {
                queue.add(next)
            }
        }
    }

    println(if(answer.size == singer) answer.joinToString("\n") else "0")
}