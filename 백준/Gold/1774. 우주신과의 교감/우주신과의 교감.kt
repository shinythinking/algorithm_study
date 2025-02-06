import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (vertex, edge) = reader.readLine().split(' ').map { it.toInt() }
    val disjointSet = DisjointSet(vertex + 1)
    val comp = Comparator<Pair<Pair<Int, Int>, Double>> { o1, o2 -> ((o1.second - o2.second) * 1_000).toInt() }
    val pq = PriorityQueue<Pair<Pair<Int, Int>, Double>>(comp)
    val positions = Array<Pair<Int, Int>>(vertex + 1) { Pair(0, 0) }
    var answer = 0.0

    repeat(vertex) { i ->
        val (x, y) = reader.readLine().split(' ').map { it.toInt() }
        positions[i + 1] = Pair(x, y)
    }

    repeat(edge) {
        val (n1, n2) = reader.readLine().split(' ').map { it.toInt() }
        disjointSet.union(n1, n2)
    }

    for(i in 1 .. vertex) {
        for(j in i .. vertex) {
            if(disjointSet.find(i) != disjointSet.find(j)) {
                pq.offer(Pair(Pair(i, j), calcDist(positions[i], positions[j])))
            }
        }
    }

    while(confirmAllConnected(disjointSet, vertex)){
        val polled = pq.poll()
        val nodes = polled.first
        val cost = polled.second
        if(disjointSet.find(nodes.first) != disjointSet.find(nodes.second)) {
            answer += cost
            disjointSet.union(nodes.first, nodes.second)
        }
    }

    println(String.format("%.2f", answer))
}

fun confirmAllConnected(disjointSet: DisjointSet, num: Int): Boolean {
    val prev: Int = disjointSet.find(1)
    for(i in 2..num) {
        if(prev != disjointSet.find(i))
            return true
    }
    return false
}

fun calcDist(a: Pair<Int, Int>, b: Pair<Int, Int>): Double {
    return Math.sqrt((a.first - b.first).toDouble() * (a.first - b.first) + (a.second - b.second).toDouble() * (a.second - b.second))
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