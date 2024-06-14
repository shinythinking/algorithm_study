import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
	val(row, col) = readLine().split(' ').map{ it.toInt() }
	val board = Array(row){ i ->
		if(i  % 2 == 0){
			CharArray(col){'#'}
		} else{
			CharArray(col){'.'}
		}
	}
	for(i in 1 until row step(4)){
		board[i][board[0].lastIndex] = '#'
	}
	for(i in 3 until row step(4)){
		board[i][0] = '#'
	}
	
	val answer = StringBuilder()
	for(row in board){
		answer.append(row.joinToString("")).append('\n')
	}
	print(answer)
}