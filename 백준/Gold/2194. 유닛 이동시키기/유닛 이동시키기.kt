fun main() {
    val HUDDLE = 1
    val br = System.`in`.bufferedReader()
    val dRow = intArrayOf(0,0,1,-1)
    val dCol = intArrayOf(1,-1,0,0)
    val queue = ArrayDeque<Pair<Pair<Int, Int>,Int>>()
    val (r,c,unitR,unitC,huddleCnt) = br.readLine().split(" ").map{it.toInt()}
    val board = Array(r) {
        IntArray(c){0}
    }
    val visited = Array(r) {
        BooleanArray(c){false}
    }

    repeat(huddleCnt) {
        val (row, col) = br.readLine().split(" ").map{it.toInt() - 1}
        board[row][col] = HUDDLE
    }
/*
    println("Log1 for Board")
    for(i in 0 until r) {
        println(board[i].joinToString(" "))
    }
*/
    val (startRow, startCol) = br.readLine().split(" ").map{it.toInt() - 1}
    val (targetRow, targetCol) = br.readLine().split(" ").map{it.toInt() - 1}

    visited[startRow][startCol] = true
    queue.addLast(Pair(startRow, startCol) to 0)

    while(queue.isNotEmpty()) {
        val dequeue = queue.removeFirst()
        for(i in 0..3) {
            val nextR = dequeue.first.first + dRow[i]
            val nextC = dequeue.first.second + dCol[i]
            val endR = nextR + unitR -1
            val endC = nextC + unitC -1
            if(nextR< 0 || nextC <0||endR>=r || endC >= c) {
                /*println("""
                    === out
                    nextR : $nextR
                    nextC : $nextC
                    targetR : $targetR
                    targetC : $targetC
                """.trimIndent())
                */
                continue
            }
            if(visited[nextR][nextC]) {
                /*println("""
                    === visited
                    nextR : $nextR
                    nextC : $nextC
                    targetR : $endR
                    targetC : $endC
                """.trimIndent())*/
                continue
            }
            if(!canGo(board, nextR to nextC, endR to endC)) {
                /*println("""
                    === cango
                    nextR : $nextR
                    nextC : $nextC
                    targetR : $endR
                    targetC : $endC
                """.trimIndent())*/
                continue
            }

            if(nextR == targetRow && nextC == targetCol) {
                println(dequeue.second + 1)
                return
            }
            visited[nextR][nextC] = true
            queue.addLast(Pair(nextR, nextC) to dequeue.second + 1)

        }
    }
    println(-1)
    return
}

fun canGo(
    board: Array<IntArray>,
    startPoint: Pair<Int,Int>,
    endPoint: Pair<Int, Int>
): Boolean {
    val sR = startPoint.first
    val sC = startPoint.second
    val eR = endPoint.first
    val eC = endPoint.second
    for(i in sR..eR) {
        for(j in sC..eC) {
            if(board[i][j] == 1){
                return false
            }
        }
    }
    return true
}

