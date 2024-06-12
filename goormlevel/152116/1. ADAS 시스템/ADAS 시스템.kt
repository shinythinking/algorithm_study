import java.io.*
import java.util.*

lateinit var numberBoard: Array<IntArray>
data class Pos(
    val row: Int,
    val col: Int,
    var type: Char = '0'
)
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (row, col) = readLine().split(' ').map{ it.toInt() }
    val board = Array(row){
        readLine().toCharArray()
    }
    val visited = Array(row){BooleanArray(col)}
    numberBoard = Array(row) { IntArray(col) }
    var answer = 0
    var startR = 0
    var startC = 0

    val pq = PriorityQueue<Pos>(compareBy({it.type}, {it.row}, {it.col}))
    for((i, line) in board.withIndex()){
        for((j, ch) in line.withIndex()){
            if(ch == 'P'){
                fillBoard(i, j)
                board[i][j] = '.'
                numberBoard[i][j] -= 4
            } else if(ch == 'S'){
                board[i][j] = '.'
                startR = i
                startC = j
                pq.offer(Pos(i, j))
            }
        }
    }

    numberBoard[startR][startC] = 0

    val dRow = intArrayOf(0, 0, 1, -1)
    val dCol = intArrayOf(1, -1, 0, 0)

    while(true){
        val start = pq.poll()
        visited[start.row][start.col] = true
        answer += numberBoard[start.row][start.col]

        for(i in 0..3){
            val newR = start.row + dRow[i]
            val newC = start.col + dCol[i]

            if(newR < 0 || newC < 0 || newR > numberBoard.lastIndex || newC > numberBoard[0].lastIndex)
                continue
            if(visited[newR][newC])
                continue
            visited[newR][newC] = true
            if(board[newR][newC] == 'E'){
				if(answer >= 0)
                print(answer)
				else print(0)
                return
            }
            pq.offer(Pos(newR, newC, board[newR][newC]))
        }
    }
}

fun fillBoard(row: Int, col: Int){
    val fromR = if(row - 1 < 0) 0 else row - 1
    val toR = if(row + 1 > numberBoard.lastIndex) numberBoard.lastIndex else row + 1

    val fromC = if(col - 1 < 0) 0 else col - 1
    val toC = if(col + 1 > numberBoard[0].lastIndex) numberBoard[0].lastIndex else col + 1

    for(i in fromR..toR){
        for(j in fromC..toC){
            numberBoard[i][j] ++
        }
    }
}