import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val tc = reader.readLine().toInt()

    val answer = buildString{
        repeat(tc) {
            val (v, e) = reader.readLine().split(" ").map { it.toInt() }
            val vertexes = IntArray(v + 1)
            val queue = LinkedList<Int>()
            val visited = BooleanArray(v + 1)
            val matrix = Array(v + 1) {
                mutableListOf<Int>()
            }
            repeat(e) {
                val (from, to) = reader.readLine().split(" ").map { it.toInt() }
                matrix[from].add(to)
                matrix[to].add(from)
            }
            var success: Boolean = true
            for(i in 1..v) {
                if(visited[i]) continue
                queue.add(i)
                vertexes[i] = 1

                while(queue.isNotEmpty()){
                    val polled = queue.removeFirst()
                    val parent = vertexes[polled]
                    visited[polled] = true
                    for(node in matrix[polled]) {
                        if(visited[node]) continue
                        if(vertexes[node] == parent) {
                            success = false
                            break
                        }
                        queue.addLast(node)
                        vertexes[node] = parent * -1
                    }
                }
                if(!success) break
            }
            if(success) appendLine("YES") else appendLine("NO")
        }
    }
    println(answer)
}