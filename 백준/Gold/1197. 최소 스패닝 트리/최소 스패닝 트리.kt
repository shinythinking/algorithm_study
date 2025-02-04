import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (vertex, numOfEdge) = reader.readLine().split(" ").map { it.toInt() }
    val comp = Comparator<Pair<Pair<Int, Int>, Int>>{ p1, p2 -> p1.second - p2.second}
    val pq = PriorityQueue<Pair<Pair<Int, Int>, Int>>(comp)
    val disjointSet = DisjointSet(vertex + 1)
    var answer = 0
    var pickedEdge = 0

    repeat(numOfEdge) {
        val (n1, n2, cost) = reader.readLine()!!.split(" ").map { it.toInt() }
        pq.offer(Pair(Pair(n1, n2), cost))
    }

    while(pickedEdge != vertex - 1) {
        val edge = pq.poll()
        val coordinate = edge.first
        val cost = edge.second
        if(disjointSet.find(coordinate.first) != disjointSet.find(coordinate.second)) {
            answer += cost
            disjointSet.union(coordinate.first, coordinate.second)
            pickedEdge++
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