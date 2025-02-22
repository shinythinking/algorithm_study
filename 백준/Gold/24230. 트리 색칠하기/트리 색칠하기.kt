fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val targets = listOf(0) + reader.readLine().split(" ").map { it.toInt() }
    val graph = Array(num + 1){mutableListOf<Int>()}
    val visited = BooleanArray(num + 1)
    var answer = 0
    repeat(num - 1) {
        val (a, b) = reader.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    fun dfs(parent: Int, node: Int) {
        if(visited[node]) return
        visited[node] = true
        if(targets[parent] != targets[node]) answer++

        for(child in graph[node]) {
            dfs(node, child)
        }
    }

    dfs(0,1)
    println(answer)
}