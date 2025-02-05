import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val coordinates = Array<Pair<Float, Float>>(num) { Pair(0f, 0f) }
    val comp = Comparator<Pair<Pair<Int, Int>, Float>> { o1, o2 -> (o1.second - o2.second).toInt() }
    val pq = PriorityQueue<Pair<Pair<Int, Int>, Float>>(comp)
    var answer = 0.0
    var count = 0
    val disjointSet = DisjointSet(num)

    repeat(num) { index ->
        val (x, y) = reader.readLine().split(" ").map { it.toFloat() }
        coordinates[index] = Pair(x, y)
    }

    for (i in 0 until num) {
        for (j in i until num) {
            val a = coordinates[i]
            val b = coordinates[j]
            val dist = (a.first - b.first) * (a.first - b.first) + (a.second - b.second) * (a.second - b.second)
            pq.offer(Pair(Pair(i, j), dist))
        }
    }

    while(count != num - 1) {
        val polled = pq.poll()
        val nodes = polled.first
        val cost = polled.second
        if(disjointSet.find(nodes.first) != disjointSet.find(nodes.second)) {
            count++
            answer += Math.sqrt(cost.toDouble())
            disjointSet.union(nodes.first, nodes.second)
        }
    }
    println(answer)
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

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootY != rootX) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY
            } else {
                parent[rootY] = rootX
                rank[rootX] += 1
            }
        }
    }
}