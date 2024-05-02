import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val(row, col) = readLine().split(" ").map { it.toInt() }
    var (rowM, colM, direction) = readLine()!!.split(" ").map { it.toInt() }
    var answer = 1
    direction = when(direction){
        0 -> 0
        1 -> 3
        2 -> 2
        else -> 1
    }

    val map = Array(row){IntArray(col) }

    for(i in 0 until row){
        val input = readLine().split(" ").map { it.toInt() }
        map[i] = input.toIntArray()
    }

    val dRow = arrayOf(-1, 0, 1, 0, -1, 0, 1, 0)
    val dCol = arrayOf(0, -1, 0, 1, 0, -1, 0, 1)

    var next = true
    map[rowM][colM] = 2
    while(rowM in 0 until row && colM in 0 until col){
        next = true
        for(i in direction + 1 .. direction + 4){
            val nextRow = rowM + dRow[i]
            val nextCol = colM + dCol[i]
            if(nextRow !in 0 until row || nextCol !in 0 until col)
                continue
            if(map[nextRow][nextCol] == 0){
                rowM = nextRow
                colM = nextCol
                map[rowM][colM] = 2
                answer++
                direction = i % 4
                next = false
                break
            }
        }
        if(next){
            rowM += dRow[direction + 2]
            colM += dCol[direction + 2]
            if(map[rowM][colM] == 1)
                break
        }
    }
    print(answer)
}