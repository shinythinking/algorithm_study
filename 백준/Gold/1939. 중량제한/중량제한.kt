fun main() {
    val br = System.`in`.bufferedReader()
    val (node, edge) = br.readLine().split(" ").map{it.toInt()}
    val bridges = mutableListOf<Bridge>()
    val parent = IntArray(node + 1){ it }
    val strongBridges = Array(node + 1) {
        BooleanArray(node + 1){false}
    }
    repeat(edge) {
        val (a,b,c) = br.readLine().split(" ").map{it.toInt()}
        bridges.add(Bridge(a,b,c))
    }
    val (from, to) = br.readLine().split(" ").map{it.toInt()}
    bridges.sortByDescending {it.weight}

    fun find(x: Int): Int {
        if(x == parent[x]) return x
        parent[x] = find(parent[x])
        return parent[x]
    }
    fun union(x:Int, y:Int) {
        val pX = find(x)
        val pY = find(y)
        parent[pX] = pY
    }
    for((a, b, weight) in bridges) {
        if(strongBridges[a][b]) continue
        
        union(a, b)
        strongBridges[a][b] = true
        strongBridges[b][a] = true
        if(find(from) == find(to)) {
            println(weight)
            return
        }
    }

}
data class Bridge(val a:Int, val b:Int, val weight:Int)