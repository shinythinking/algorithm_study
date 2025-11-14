fun main() {
    val dRow = intArrayOf(1, -1, 0, 0)
    val dCol = intArrayOf(0, 0, 1, -1)
    val (r,c) = readln().split(" ").map { it.toInt() }
    val visited = Array(r) {
        BooleanArray(c)
    }
    val isFlow = Array(r) {
        readln().map { it == '0' }
    }
    val queue = mutableListOf<Pair<Int, Int>>()
    for(i in 0 until c) {
        if(isFlow[0][i]) {
            queue.add(0 to i)
            visited[0][i] = true
        }
    }

    while(queue.isNotEmpty()) {
        val cur = queue.removeFirst()
        for(i in 0..3) {
            val nextR = cur.first + dRow[i]
            val nextC = cur.second + dCol[i]
            if(nextR !in 0 until r || nextC !in 0 until c) continue
            if(visited[nextR][nextC]) continue
            visited[nextR][nextC] = true
            if(!isFlow[nextR][nextC]) continue
            queue.add(nextR to nextC)
        }
    }
    for(i in 0 until c) {
        if(visited[r-1][i]) {
            println("YES")
            return
        }
    }
    println("NO")
}