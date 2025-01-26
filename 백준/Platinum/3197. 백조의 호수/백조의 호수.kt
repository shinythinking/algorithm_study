import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (row, col) = reader.readLine().split(" ").map { it.toInt() }
    val x = -1
    val l = -2
    val dot = 0
    val river = Array(row) {
        reader.readLine().map {
            when (it) {
                '.' -> dot
                'X' -> x
                'L' -> l
                else -> -3
            }
        }.toIntArray()
    }
    var answer = 0
    var area = 1
    val birdArea = mutableListOf<Int>()

    val dRow = intArrayOf(0, 1, 0, -1)
    val dCol = intArrayOf(1, 0, -1, 0)
    var visited = Array(row) { BooleanArray(col) }
    val queue = LinkedList<Pair<Int, Int>>()
    var startPoints: Map<Int, List<Pair<Int, Int>>>
    val nextStartPoints = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

    for (i in river.indices) {
        for (j in river[i].indices) {
            if (river[i][j] == x) continue

            if (visited[i][j]) continue

            queue.addLast(Pair(i, j))
            nextStartPoints[area] = mutableListOf(Pair(i, j))
            if (river[i][j] == l) birdArea.add(area)
            river[i][j] = area

            while (queue.isNotEmpty()) {
                val (r, c) = queue.removeFirst()
                for (k in 0..3) {
                    val newR = r + dRow[k]
                    val newC = c + dCol[k]
                    if (newR !in 0 until row || newC !in 0 until col) continue

                    if (visited[newR][newC]) continue
                    visited[newR][newC] = true

                    if (river[newR][newC] == x) {
                        val list = nextStartPoints.getOrPut(area) {
                            mutableListOf()
                        }
                        list.add(Pair(r,c))
                        continue
                    }

                    if (river[newR][newC] == l) birdArea.add(area)
                    river[newR][newC] = area
                    queue.addLast(newR to newC)
                }
            }
            area++
        }
    }

    val disjointSet = DisjointSet(area)
    visited = Array(row) { BooleanArray(col) }
    while (true) {
        if (disjointSet.find(birdArea[0]) == disjointSet.find(birdArea[1])) {
            println(answer)
            return
        }
        queue.clear()
        startPoints = nextStartPoints.toMap()
        nextStartPoints.clear()
        for ((areaNum, startList) in startPoints) {
            for (start in startList) {
                queue.add(start)
                while (!queue.isEmpty()) {
                    val (r, c) = queue.removeFirst()
                    for (k in 0..3) {
                        val newR = r + dRow[k]
                        val newC = c + dCol[k]

                        if (newR !in 0 until row || newC !in 0 until col) continue

                        if (visited[newR][newC]) continue
                        visited[newR][newC] = true

                        if (river[newR][newC] == x) {
                            river[newR][newC] = areaNum
                            val list = nextStartPoints.getOrPut(areaNum) {
                                mutableListOf()
                            }
                            list.add(Pair(newR, newC))
                            for (l in 0..3) {
                                val newRR = newR + dRow[l]
                                val newCC = newC + dCol[l]

                                if (newRR !in 0 until row || newCC !in 0 until col) continue
                                if (river[newRR][newCC] != x && river[newRR][newCC] != river[newR][newC]) {
                                    disjointSet.union(areaNum, river[newRR][newCC])
                                }
                            }
                            continue
                        } else if (river[newR][newC] == areaNum) {
                            queue.addLast(Pair(newR, newC))
                        } else {
                            if (disjointSet.find(areaNum) == disjointSet.find(river[newR][newC])) continue
                            disjointSet.union(areaNum, river[newR][newC])
                        }
                    }
                }
            }
        }
        answer++
    }
}

class DisjointSet(size: Int) {
    private val parent = IntArray(size) { it }
    private val rank = IntArray(size) { 1 }
    private val size = IntArray(size) { 1 }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int): Int {
        val rootX = find(x)
        val rootY = find(y)

        if (rootY != rootX) {
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