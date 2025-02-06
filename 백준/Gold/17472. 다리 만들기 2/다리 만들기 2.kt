import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (row, col) = reader.readLine().split(' ').map { it.toInt() }
    val isGround = Array(row) {
        reader.readLine().split(" ").map { it == "1" }
    }
    val map = Array(row) { IntArray(col) }
    val queue = LinkedList<Pair<Int, Int>>()
    val visited = Array(row) { BooleanArray(col) }
    val dRow = intArrayOf(0, 0, 1, -1)
    val dCol = intArrayOf(-1, 1, 0, 0)
    var groundNum = 1
    for (i in 0 until row) {
        for (j in 0 until col) {
            if (!isGround[i][j] || visited[i][j]) continue
            visited[i][j] = true
            queue.offerLast(Pair(i, j))
            while (queue.isNotEmpty()) {
                val cur = queue.pollFirst()
                map[cur.first][cur.second] = groundNum
                for (index in 0..3) {
                    val newR = cur.first + dRow[index]
                    val newC = cur.second + dCol[index]
                    if (newR !in 0 until row || newC !in 0 until col) continue
                    if (!isGround[newR][newC]) continue
                    if (visited[newR][newC]) continue
                    visited[newR][newC] = true
                    queue.offer(Pair(newR, newC))
                }
            }
            groundNum++
        }
    }

    val disjointSet = DisjointSet(groundNum)
    val comp = Comparator<Pair<Pair<Int, Int>, Int>> { o1, o2 -> o1.second - o2.second }
    val pq = PriorityQueue<Pair<Pair<Int, Int>, Int>>(comp)
    var cnt = 0
    var answer = 0
    for (i in 0 until row) {
        for (j in 0 until col) {
            if (!isGround[i][j]) continue
            var curRow = i
            var curCol = j
            val from = map[i][j]
            while (curRow < row - 1) {
                curRow++
                when (map[curRow][curCol]) {
                    from -> break
                    0 -> continue
                    else -> {
                        val to = map[curRow][curCol]
                        val cost = curRow - i - 1
                        pq.offer(Pair(Pair(from, to), cost))
                        break
                    }
                }
            }
            curRow = i

            while (curRow > 0) {
                curRow--
                when (map[curRow][curCol]) {
                    from -> break
                    0 -> continue
                    else -> {
                        val to = map[curRow][curCol]
                        val cost = i - curRow - 1
                        pq.offer(Pair(Pair(from, to), cost))
                        break
                    }
                }
            }
            curRow = i

            while (curCol < col - 1) {
                curCol++
                when (map[curRow][curCol]) {
                    from -> break
                    0 -> continue
                    else -> {
                        val to = map[curRow][curCol]
                        val cost = curCol - j - 1
                        pq.offer(Pair(Pair(from, to), cost))
                        break
                    }
                }
            }
            curCol = j

            while (curCol > 0) {
                curCol--
                when (map[curRow][curCol]) {
                    from -> break
                    0 -> continue
                    else -> {
                        val to = map[curRow][curCol]
                        val cost = j - curCol - 1
                        pq.offer(Pair(Pair(from, to), cost))
                        break
                    }
                }
            }
            curCol = j
        }
    }

    while (cnt != groundNum - 2) {
        val polled = pq.poll()
        if (polled == null) {
            answer = -1
            break
        }
        val nodes = polled.first
        val cost = polled.second
        if (cost < 2) continue
        if (disjointSet.find(nodes.first) != disjointSet.find(nodes.second)) {
            disjointSet.union(nodes.second, nodes.first)
            answer += cost
            cnt++
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