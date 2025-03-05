data class Node(val x: Int, val y: Int, val cost: Int)

fun main() {
    val reader = System.`in`.bufferedReader()
    val (house, route) = reader.readLine().split(" ").map { it.toInt() }

    val routes = Array(route) {
        val (x, y, cost) = reader.readLine().split(" ").map { it.toInt() }
        Node(x, y, cost)
    }.sortedBy { it.cost }

    if(house == 2){
        println("0")
        return
    }

    val disjointSet = DisjointSet(house + 1)
    
    var cnt = 0
    var answer = 0
    for (node in routes) {
        if(disjointSet.find(node.x) != disjointSet.find(node.y)) {
            disjointSet.union(node.x, node.y)
            cnt++
            answer += node.cost
            if(cnt == house - 2) break

        }
    }
    println(answer)
}
class DisjointSet(size: Int) {
    private val parent = IntArray(size) { it }
    private val rank = IntArray(size) { 1 }

    fun findSameParent(x: Int): Int {
        val p = find(x)
        return parent.count { it == p }
    }

    fun getAmountOfDisjoint(): Int {
        for (i in 1..parent.lastIndex) {
            find(i)
        }
        return parent.toSet().size - 1
    }

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