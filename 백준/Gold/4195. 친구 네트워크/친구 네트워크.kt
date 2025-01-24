fun main() {
    val reader = System.`in`.bufferedReader()
    val testcase = reader.readLine().toInt()

    val answer = buildString {
        repeat(testcase) {
            val num = reader.readLine().toInt()
            val people = mutableMapOf<String, Int>()
            val disjointSet = DisjointSet(2 * num)
            var index = 0
            repeat(num) {
                val (p1, p2) = reader.readLine().trim().split(" ")
                if (!people.containsKey(p1)) people[p1] = index++
                if (!people.containsKey(p2)) people[p2] = index++

                val ans = disjointSet.union(people[p1]!!, people[p2]!!)
                appendLine(ans)
            }
        }
    }
    println(answer)
}

class DisjointSet(size: Int) {
    private val parent = IntArray(size) { it }
    private val rank = IntArray(size) { 1 }
    private val size = IntArray(size) { 1 }
//
//    fun getSameRoot(x: Int, len: Int): Int {
//        for (i in 0 until len) {
//            find(i)
//        }
//        return parent.count { it == x }
//    }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int): Int {
        val rootX = find(x)
        val rootY = find(y)

        if(rootY != rootX) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX
                size[rootX] += size[rootY]
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY
                size[rootY] += size[rootX]
            } else {
                parent[rootY] = rootX
                size[rootX] += size[rootY]
                rank[rootX] += 1
            }
        }
        return size[find(x)]
    }
}