val dRow = intArrayOf(0,0,1,-1)
val dCol = intArrayOf(1,-1,0,0)
fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val board = Array(n) {
        br.readLine().split(" ").map{it.toInt()}.toIntArray()
    }
    val queueList = name(board)
//    println("=== namedBoard")
//    for(i in  board) {
//        println(i.joinToString(" "))
//    }
//    for(i in queueList) {
//        println(i.joinToString(" "))
//    }
    var ans = Int.MAX_VALUE
    var idx = 1
    for (queue in queueList) {
        idx ++
        val visited = Array(board.size){
            BooleanArray(board[0].size)
        }
        for(p in queue) {
            visited[p.r][p.c] = true
        }
        while(queue.isNotEmpty()) {
            val polled = queue.removeFirst()
            for(i in 0..3) {
                val newR = polled.r + dRow[i]
                val newC = polled.c + dCol[i]
                if(newR !in 0 until n || newC !in 0 until n) continue
                if(board[newR][newC] !=0 && board[newR][newC] != idx) {
                    ans = Math.min(ans, polled.cost)
                    continue
                }
                if(visited[newR][newC]) continue
                visited[newR][newC] = true
                queue.addLast(Point(newR, newC, polled.cost + 1))
            }
        }
    }
    println(ans)
}

fun name(board:Array<IntArray>): MutableList<ArrayDeque<Point>>{
    var idx = 2
    val visited = Array(board.size){
        BooleanArray(board[0].size)
    }
    val queueList = mutableListOf<ArrayDeque<Point>>()
    for(i in 0 until board.size) {
        for(j in 0 until board[0].size) {
            if(board[i][j] == 1) {
                val newQueue = ArrayDeque<Point>()
                val queue = ArrayDeque<Point>()
                val start = Point(i, j, 0)
                queue.addLast(start)
                visited[i][j] = true
                board[i][j] = idx
                newQueue.add(Point(i, j, 0))

                while(queue.isNotEmpty()) {
                    val dequeue = queue.removeFirst()
                    for(i in 0..3) {
                        val newR = dequeue.r+dRow[i]
                        val newC = dequeue.c+dCol[i]
                        if(newR !in 0 until board.size || newC !in 0 until board.size) continue
                        if(board[newR][newC] == 0) continue
                        if(visited[newR][newC]) continue
                        visited[newR][newC] = true
                        val newPoint = Point(newR, newC, 0)
                        newQueue.add(newPoint)
                        board[newR][newC] = idx
                        queue.addLast(newPoint)
                    }
                }
                queueList.add(newQueue)
                idx++
            }
        }
    }
    return queueList
}

data class Point(val r: Int, val c: Int, val cost: Int)