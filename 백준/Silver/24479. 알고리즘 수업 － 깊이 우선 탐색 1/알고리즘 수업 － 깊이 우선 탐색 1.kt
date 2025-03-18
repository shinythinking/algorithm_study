fun main() {
    val reader = System.`in`.bufferedReader()
    val (vertex, edge, start) = reader.readLine().split(" ").map { it.toInt() }
    val graph = Array(vertex + 1) { mutableListOf<Int>() }
    repeat(edge) {
        val (from, to) = reader.readLine().split(" ").map { it.toInt() }
        graph[from].add(to)
        graph[to].add(from)
    }
    for(i in 1..vertex) {
        graph[i].sort()
    }
    val visited = IntArray(vertex + 1) { 0 }
    var idx = 1
    fun dfs(node: Int) {
        visited[node] = idx ++
        for(next in graph[node]) {
            if(visited[next] == 0) {
                dfs(next)
            }
        }
    }
    dfs(start)
    println(visited.drop(1).joinToString("\n"))
}