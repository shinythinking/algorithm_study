import java.util.*
import java.io.*

data class Balls(
    val red: Ball,
    val blue: Ball,
    val cnt: Int
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Balls) return false

        if (red != other.red) return false
        if (blue != other.blue) return false

        return true
    }

    override fun hashCode(): Int {
        var result = red.hashCode()
        result = 31 * result + blue.hashCode()
        return result
    }
}

data class Ball (
    var row: Int,
    var col: Int
)

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val(row, col) = readLine().split(' ').map(String::toInt)
    val board = Array(row) { CharArray(col) }
    val set = mutableSetOf<Balls>()

    var red = Ball(0 , 0)
    var blue = Ball(0 , 0)


    for(i in 0 until row){
        board[i] = readLine().toCharArray()
        val indexR = board[i].indexOf('R')
        val indexB = board[i].indexOf('B')
        if(indexR != -1){
            red = Ball(i, indexR)
            board[red.row][red.col] = '.'
        }
        if(indexB != -1) {
            blue = Ball(i, indexB)
            board[blue.row][blue.col] = '.'
        }
    }

    val queue = LinkedList<Balls>()
    queue.offer(Balls(red, blue, 0))
    set.add(Balls(red, blue, 0))

    val dRow = intArrayOf(1, -1, 0, 0)
    val dCol = intArrayOf(0, 0, 1, -1)

    while(queue.isNotEmpty()){
        val setting = queue.poll()
        red = setting.red
        blue = setting.blue

        var isFailed = false
        if(setting.cnt == 10){
            break
        }

        for(i in 0..3){
            var reversed = false
            isFailed = false

            var first = Ball(red.row, red.col)
            var second = Ball(blue.row, blue.col)
            when(i){
                0 ->{
                    if(red.row < blue.row){
                        val temp = first
                        first = second
                        second = temp
                        reversed = true
                    }
                }
                1 -> {
                    if(red.row > blue.row){
                        val temp = first
                        first = second
                        second = temp
                        reversed = true
                    }
                }
                2 -> {
                    if(red.col < blue.col){
                        val temp = first
                        first = second
                        second = temp
                        reversed = true
                    }
                }
                else -> {
                    if(red.col > blue.col){
                        val temp = first
                        first = second
                        second = temp
                        reversed = true
                    }
                }
            }
            var firstRow = first.row
            var firstCol = first.col
            var secondRow = second.row
            var secondCol = second.col

            var redIn = false

            while(true){
                firstRow += dRow[i]
                firstCol += dCol[i]
                if(board[firstRow][firstCol] == 'O'){
                    if(reversed){
                        isFailed = true
                        break
                    } else {
                        redIn = true
                        break
                    }
                } else if(board[firstRow][firstCol] != '.'){
                    firstRow -= dRow[i]
                    firstCol -= dCol[i]
                    first.row = firstRow
                    first.col = firstCol
                    break
                }
            }
            var lostChar = '.'
            if(!redIn) {
                lostChar = board[firstRow][firstCol]
                board[firstRow][firstCol] = '#'
            }
            while(true){
                secondRow += dRow[i]
                secondCol += dCol[i]
                if(board[secondRow][secondCol] == 'O'){
                    if(reversed && !isFailed){
                        print(setting.cnt + 1)
                        return
                    }else{
                        isFailed = true
                        break
                    }
                } else if(board[secondRow][secondCol] != '.'){
                    secondRow -= dRow[i]
                    secondCol -= dCol[i]
                    second.row = secondRow
                    second.col = secondCol
                    break
                }
            }
            
            if(!redIn) {
                board[firstRow][firstCol] = lostChar
            }

            if(isFailed){
                continue
            }

            if(redIn){
                print(setting.cnt + 1)
                return
            }
            
            if(reversed){
                val balls = Balls(second, first,setting.cnt + 1)
                if(!set.contains(balls)) {
                    queue.offer(balls)
                    set.add(balls)
                }
            } else {
                val balls = Balls(first, second, setting.cnt + 1)
                if(!set.contains(balls)) {
                    queue.offer(balls)
                    set.add(balls)
                }
            }

        }
    }
    print(-1)

}