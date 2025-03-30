fun cycle(graph: IntArray): Int {
    val visited = BooleanArray(graph.size)
    val ans = BooleanArray(graph.size)

    fun dfs(node: Int) {
        val stack = mutableListOf<Int>()
        val stackSet = mutableSetOf<Int>()  
        var current = node

        while (true) {
            if (stackSet.contains(current)) {  
                while (stack.isNotEmpty()) {
                    val popped = stack.removeLast()
                    ans[popped] = true
                    if (popped == current) break
                }
                return
            }

            if (visited[current]) return

            visited[current] = true
            stack.add(current)
            stackSet.add(current)  

            current = graph[current]
        }
    }

    for (i in 1..graph.lastIndex) {
        if (!visited[i]) {
            dfs(i)
        }
    }
    return ans.count { !it } - 1
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val testcase = reader.readLine().toInt()
    val answer = buildString {
        repeat(testcase) {
            val num = reader.readLine().toInt()
            val students = intArrayOf(0) + reader.readLine().split(" ").map { it.toInt() }

            appendLine(cycle(students))
        }
    }
    println(answer)
}
