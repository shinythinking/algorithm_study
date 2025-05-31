fun main() {
    val reader = System.`in`.bufferedReader()
    val tc = reader.readLine().toInt()
    val ans = buildString {
        repeat(tc) {
            val num = reader.readLine().toInt()
            val adjList = Array(num + 1) {
                mutableListOf<Int>()
            }
            val nums = reader
                .readLine()
                .split(" ")
                .map { it.toInt() }
                .forEachIndexed { i, v ->
                    adjList[i + 1].add(v)
                }
            appendLine(isCycle(adjList))
        }
    }
    println(ans)
}

fun isCycle(adjList: Array<MutableList<Int>>): Int {
    val visited = BooleanArray(adjList.size)
    val prevNodes = BooleanArray(adjList.size)
    var answer = 0

    fun dfs(node: Int): Boolean {
        if (prevNodes[node]) return true
        if (visited[node]) return false

        visited[node] = true
        prevNodes[node] = true

        for (next in adjList[node]) {
            if (dfs(next)) return true
        }

        prevNodes[node] = false
        return false
    }

    for (i in adjList.indices) {
        if (!visited[i]) {
            if (dfs(i)) answer++
        }
    }
    return answer
}