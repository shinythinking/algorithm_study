fun main() {
    val br = System.`in`.bufferedReader()
    val dRow = intArrayOf(0,0,1,-1)
    val dCol = intArrayOf(1,-1,0,0)
    val n = br.readLine().toInt()
    val board = Array(n) {
        br.readLine()
    }
    val visited = Array(n) {
        IntArray(n) { -1 }
    }
    val queue = ArrayDeque<Position>()
    queue.addLast(Position(0,0))
    visited[0][0]=0
    while(queue.isNotEmpty()) {
        val polled = queue.removeFirst()
        for(i in 0..3) {
            val nextR = polled.r+dRow[i]
            val nextC = polled.c+dCol[i]
            if(nextR !in 0 until n || nextC !in 0 until n) continue
            if(visited[nextR][nextC] != -1) continue
            if(board[nextR][nextC] == '1'){
                queue.addFirst(Position(nextR, nextC))
                visited[nextR][nextC] = visited[polled.r][polled.c]
            } else {
                queue.addLast(Position(nextR, nextC))
                visited[nextR][nextC] = visited[polled.r][polled.c] + 1
            }
        }
    }
    println(visited[n-1][n-1])
}
data class Position(val r: Int, val c: Int)