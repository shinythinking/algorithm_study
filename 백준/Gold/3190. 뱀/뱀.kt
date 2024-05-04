import java.util.*
import java.io.*
import kotlin.collections.ArrayDeque

data class Pos(val row: Int, val col: Int)
data class Rotation(val time: Int, val rotate: Int)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val size = readLine()!!.toInt()
    //1 apple, 2 snake
    val board = Array(size){ IntArray(size) }
    val snake = ArrayDeque<Pos>()

    val apple = readLine()!!.toInt()
    for(i in 0 until apple){
        val(row, col) = readLine()!!.split(" ").map { it.toInt() }
        board[row - 1][col - 1] = 1
    }

    val directNum = readLine().toInt()
    val rotationList = LinkedList<Rotation>()
    for(i in 0 until directNum){
        val(time, rotate) = readLine().split(" ")
        val rotateInt = if(rotate == "D") 1 else 3
        rotationList.offer(Rotation(time.toInt(), rotateInt))
    }

    val dRow = listOf(0, 1, 0, -1)
    val dCol = listOf(1, 0, -1, 0)

    var time = 0
    snake.addLast(Pos(0, 0))
    board[0][0] = 2
    var direction = 0
    var nextRotate = rotationList.poll()
    while (true){
        time++
        val head = snake.first()
        val nextRow = head.row + dRow[direction]
        val nextCol = head.col + dCol[direction]

        if(nextCol < 0 || nextRow < 0 || nextCol >= size || nextRow >= size)
            break

        snake.addFirst(Pos(nextRow, nextCol))
        if(board[nextRow][nextCol] == 1){
            board[nextRow][nextCol] = 2
        } else if (board[nextRow][nextCol] == 0){
            board[nextRow][nextCol] = 2
            val tail = snake.removeLast()
            board[tail.row][tail.col] = 0
        } else {
            break
        }

        if(time == nextRotate.time){
            direction = (direction + nextRotate.rotate) % 4
            nextRotate = rotationList.poll() ?: Rotation(0,0)
        }
    }

    print(time)
}