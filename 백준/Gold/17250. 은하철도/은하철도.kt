class UF(num: Int) {
    val parent = IntArray(num + 1) { it }

    fun union(p1: Int, p2: Int) {
        val parentOfp1 = find(p1)
        val parentOfp2 = find(p2)
        if (parentOfp1 <= parentOfp2) {
            parent[parentOfp2] = parentOfp1
        } else {
            parent[parentOfp1] = parentOfp2
        }
    }

    fun find(p: Int): Int {
        if(parent[p] != p) {
            parent[p] = find(parent[p])
        }
        return parent[p]
    }

    fun isConnected(p1: Int, p2: Int): Boolean {
        return find(p1) == find(p2)
    }
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val (planet, road) = reader.readLine()!!.split(" ").map { it.toInt() }
    val planets = IntArray(1) + IntArray(planet) {
        reader.readLine()!!.toInt()
    }
    val uf = UF(planet)
    val ans = buildString{
        repeat(road) {
            val (a, b) = reader.readLine()!!.split(" ").map { it.toInt() }
            if (!uf.isConnected(a, b)) {
                val sum = planets[uf.find(a)] + planets[uf.find(b)]
                planets[uf.find(a)] = sum
                planets[uf.find(b)] = sum
                uf.union(a, b)
                appendLine(planets[uf.find(b)])
            } else {
                appendLine(planets[uf.find(a)])
            }
        }
    }
    println(ans)
}