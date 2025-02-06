import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    var answer = mutableListOf<Int>()
    while(true){
        val (vertex, edge) = reader.readLine().split(' ').map { it.toInt() }
        if(vertex == 0) break
        val disjointSet = DisjointSet(vertex)
        val comp = Comparator<Pair<Pair<Int, Int>, Int>>{ o1, o2 -> o1.second - o2.second }
        val pq = PriorityQueue<Pair<Pair<Int, Int>, Int>>(comp)
        var cnt = 0
        var ans = 0

        repeat(edge) {
            val (n1, n2, cost) = reader.readLine().split(' ').map { it.toInt() }
            pq.add(Pair(Pair(n1, n2), cost))
            ans += cost
        }

        while(cnt != vertex - 1) {
            val polled = pq.poll()
            val nodes = polled.first
            val cost = polled.second

            if(disjointSet.find(nodes.first) != disjointSet.find(nodes.second)) {
                disjointSet.union(nodes.second, nodes.first)
                ans -= cost
                cnt++
            }
        }
        answer.add(ans)
    }
    println(answer.joinToString("\n"))
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