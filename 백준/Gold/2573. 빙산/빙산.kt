import java.util.*
import java.io.*

data class Pos(
    val row: Int,
    val col: Int
)


fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val(row, col) = readLine().split(' ').map{it.toInt()}
    val board = Array(row){ readLine().split(' ').map{it.toInt()}.toIntArray() }
    val newBoard: Array<IntArray> = Array(row){i ->
        board[i].copyOf()
    }

    val dRow = intArrayOf(1, -1, 0, 0)
    val dCol = intArrayOf(0, 0, -1, 1)

    var answer = 0
    val queue = LinkedList<Pos>()

    while(true){
        val visited = Array(row){ BooleanArray(col) }
        var isBFS = false
        for ((i, rows) in board.withIndex()) {
            for ((j, cols) in rows.withIndex()) {
                if (board[i][j] != 0 && !visited[i][j]) {
                    if (isBFS) {
                        print(answer)
                        return
                    }
                    isBFS = true
                    queue.offer(Pos(i, j))
                    while (queue.isNotEmpty()) {
                        val polled = queue.poll()
                        var adjacentEdges = 0
                        for (k in 0..3) {
                            val newRow = polled.row + dRow[k]
                            val newCol = polled.col + dCol[k]

                            /*if(newRow < 0 || newCol < 0 || newRow >= row || newCol >= col)
                                continue
                                */

                            if (board[newRow][newCol] == 0) {
                                adjacentEdges++
                                continue
                            }
                            if (!visited[newRow][newCol]) {
                                visited[newRow][newCol] = true
                                queue.offer(Pos(newRow, newCol))
                            }
                        }
                        newBoard[polled.row][polled.col] = if (board[polled.row][polled.col] > adjacentEdges) {
                            board[polled.row][polled.col] - adjacentEdges
                        } else {
                            0
                        }

                    }
                }
            }
        }
        if(!isBFS)
            break
        
        answer++
        for(i in board.indices){
            board[i] = newBoard[i].copyOf()
        }
    }
    print(0)
}