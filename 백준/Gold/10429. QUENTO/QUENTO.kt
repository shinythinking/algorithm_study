fun main() {
    val reader = System.`in`.bufferedReader()
    val (target, n) = reader.readLine().split(" ").map { it.toInt() }
    val num = 2 * n - 1
    val map = Array(3) {
        reader.readLine()
    }
    val dRow = intArrayOf(0, 0, 1, -1)
    val dCol = intArrayOf(1, -1, 0, 0)

    val visited = Array(3) { BooleanArray(3) { false } }

    fun calc(deque: ArrayDeque<Pair<Int, Int>>): Int {
        var ans = 0
        var op = 1
        for((r, c) in deque) {
            if((c + r) % 2 == 0) {
                ans += (map[r][c] - '0') * op
            } else {
                op = if(map[r][c] == '+') 1 else -1
            }
        }
        return ans
    }

    fun dfs(deque: ArrayDeque<Pair<Int, Int>>) : ArrayDeque<Pair<Int, Int>>?{
        val (cRow, cCol) = deque.last()
        visited[cRow][cCol] = true

        if(deque.size == num && calc(deque) == target) {
            return deque
        }

        for (i in 0..3) {
            val newR = cRow + dRow[i]
            val newC = cCol + dCol[i]
            if(newR in 0 until 3 && newC in 0 until 3 && !visited[newR][newC]) {
                deque.addLast(Pair(newR, newC))
                val res = dfs(deque)
                if(res != null) return res
            }
        }

        visited[cRow][cCol] = false
        deque.removeLast()

        return null
    }
    var ans: ArrayDeque<Pair<Int, Int>>? = ArrayDeque<Pair<Int, Int>>()
    for(i in 0 until 3) {
        for(j in 0 until 3) {
            if((i + j)% 2 == 0) {
                ans = dfs(ArrayDeque(listOf(Pair(i, j))))
            }
            if(ans != null) break
        }
        if(ans != null) break
    }
    val answer = buildString {
        if (ans != null) {
            appendLine("1")
            for ((r, c) in ans) {
                appendLine("$r $c")
            }
        } else {
            appendLine("0")
        }
    }
    println(answer)
}