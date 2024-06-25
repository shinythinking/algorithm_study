import java.io.*
import java.util.*

data class Pos (val row: Int, val col: Int)

var air = 0
var cheeze = 0

fun bfs(board: Array<BooleanArray>): Array<BooleanArray>{
    val newBoard = Array(board.size){ i ->
        board[i]
    }

    val visited = Array(board.size){ BooleanArray(board[0].size) }
    val queue = LinkedList<Pos>()
    queue.offer(Pos(0, 0))

    val dRow = intArrayOf(1, -1, 0, 0)
    val dCol = intArrayOf(0, 0, 1, -1)

    while(queue.isNotEmpty()){
        val currentPos = queue.poll()

        for(i in 0..3){
            val newR = currentPos.row + dRow[i]
            val newC = currentPos.col + dCol[i]

            if(newR < 0 || newC < 0 || newR >= board.size || newC >= board[0].size)
                continue

            if(visited[newR][newC])
                continue
            visited[newR][newC] = true
            if(board[newR][newC]) {
                queue.offer(Pos(newR, newC))
                air++
            } else {
                newBoard[newR][newC] = true
                cheeze++
            }
        }
    }
    return newBoard
}

fun main() = with(System.`in`.bufferedReader()){
    val (row, col) = readLine().split(' ').map{ it.toInt() }
    // true == 공기
    var board =  Array(row){
        readLine().split(' ').map{ it == "0" }.toBooleanArray()
    }

    var answer = 0
    var prevCheeze = 0
    val total = row * col
    while(true){
        board = bfs(board)
        if(air == total)
            break
        answer++
        air = 0
        prevCheeze = cheeze
        cheeze = 0
    }
    print("$answer \n$prevCheeze")
}