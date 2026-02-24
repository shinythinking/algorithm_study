fun main() {
    val br = System.`in`.bufferedReader()
    val (r,c) = br.readLine().split(" ").map{it.toInt()}
    val dRow = intArrayOf(0, 0, 1, -1)
    val dCol = intArrayOf(1, -1, 0, 0)
    val queueForS = ArrayDeque<Pair<Pair<Int, Int>, Int>>()
    val queueForF = ArrayDeque<Pair<Pair<Int, Int>, Int>>()
    val visited = Array(r) {
        BooleanArray(c) { false }
    }

    val board = Array(r) {
        br.readLine().toCharArray()
    }
    var targetR = 0
    var targetC = 0
    for(i in 0 until r) {
        for(j in 0 until c) {
            when(board[i][j]) {
                '*' -> {
                    queueForF.addLast(Pair(i to j, 0))
                    visited[i][j] = true
                }
                'X' -> {
                    visited[i][j] = true
                }
                'S' -> {
                    queueForS.addLast(Pair(Pair(i, j), 0))
                }
                'D' -> {
                    visited[i][j] = true
                    targetR = i
                    targetC = j
                }
                else -> {}
            }
        }
    }

    while(queueForS.isNotEmpty()) {
        val currentS = queueForS.removeFirst()
        val cnt = currentS.second

        while((queueForF.firstOrNull()?.second ?: -1) == cnt){
            val currentF = queueForF.removeFirst()

            for(i in 0..3) {
                val newR = currentF.first.first + dRow[i]
                val newC = currentF.first.second + dCol[i]
                if(newR !in 0 until r || newC !in 0 until c) continue
                if(visited[newR][newC]) continue
                visited[newR][newC] = true
                queueForF.addLast(Pair(Pair(newR, newC), cnt + 1))
            }
        }
        for(i in 0..3) {
            val newR = currentS.first.first + dRow[i]
            val newC = currentS.first.second + dCol[i]
            if(newR == targetR && newC == targetC){
                println(cnt + 1)
                return
            }
            if(newR !in 0 until r || newC !in 0 until c) continue
            if(visited[newR][newC]) continue
            visited[newR][newC] = true
            queueForS.addLast(Pair(Pair(newR, newC), cnt + 1))
        }
    }
    println("KAKTUS")
}