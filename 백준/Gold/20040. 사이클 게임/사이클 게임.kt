fun main() {
    val reader = System.`in`.bufferedReader()
    val (dot, game) = reader.readLine().split(' ').map { it.toInt() }
    val cycle = DisjointSet(dot)
    val dots = mutableListOf<Pair<Int, Int>>()
    var answer = 0
    repeat(game) {
        val (left, right) = reader.readLine().split(' ').map { it.toInt() }
        dots.add(left to right)
    }
    for ((left, right) in dots) {
        answer++
        if (!cycle.union(left, right)) {
            println(answer)
            return
        }
    }
    println(0)
}

class DisjointSet(size: Int) {
    private val parent = IntArray(size) { it }
    private val rank = IntArray(size) { 1 }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val parentX = find(x)
        val parentY = find(y)

        if (parentX == parentY) return false

        if (rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX
        } else if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY
        } else {
            parent[parentY] = parentX
            rank[parentX] += 1
        }
        return true
    }
}