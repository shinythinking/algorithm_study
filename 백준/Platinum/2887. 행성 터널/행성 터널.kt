import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val parent = IntArray(n) { it }

    val planets = Array(n) { i ->
        val st = StringTokenizer(br.readLine(), " ")
        Planet(i, st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
    }

    val edges = ArrayList<Tunnel>(n * 3)

    planets.sortBy { it.x }
    for (i in 0 until n - 1) {
        edges.add(Tunnel(planets[i].idx, planets[i + 1].idx, Math.abs(planets[i].x - planets[i + 1].x)))
    }

    planets.sortBy { it.y }
    for (i in 0 until n - 1) {
        edges.add(Tunnel(planets[i].idx, planets[i + 1].idx, Math.abs(planets[i].y - planets[i + 1].y)))
    }

    planets.sortBy { it.z }
    for (i in 0 until n - 1) {
        edges.add(Tunnel(planets[i].idx, planets[i + 1].idx, Math.abs(planets[i].z - planets[i + 1].z)))
    }

    edges.sort()

    var cnt = 0
    var ans = 0L
    for (edge in edges) { 
        if (find(parent, edge.from) == find(parent, edge.to)) continue
        union(edge.from, edge.to, parent)
        ans += edge.c
        cnt++
        if(cnt == n - 1) break
    }
    println(ans)
}

data class Planet(
    val idx: Int, val x: Int, val y: Int, val z: Int
)

data class Tunnel(
    val from: Int, val to: Int, val c: Int
) : Comparable<Tunnel> {
    override fun compareTo(other: Tunnel): Int {
        return this.c.compareTo(other.c)
    }
}

fun find(parent: IntArray, x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent, parent[x])
    return parent[x]
}

fun union(x: Int, y: Int, parent: IntArray) {
    val pX = find(parent, x)
    val pY = find(parent, y)
    if (pX != pY) {
        parent[pX] = pY
    }
}