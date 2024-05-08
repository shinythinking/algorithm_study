import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val answer = StringBuilder()
    val(row, col) = readLine().split(' ').map{ it.toInt() }
    val board = Array(row){ mutableListOf<Int>() }
    for(i in 0..<row){
        board[i] += readLine().split(' ').map{ it.toInt() }
    }

    val num = readLine().toInt()
    for(i in 1..num){
        val (fromR, fromC, toR, toC) = readLine().split(' ').map{ it.toInt() - 1 }
        var sum = 0
        for(j in fromR..toR){
            for(k in fromC..toC){
                sum += board[j][k]
            }
        }
        answer.append(sum).append('\n')
    }
    print(answer)
}