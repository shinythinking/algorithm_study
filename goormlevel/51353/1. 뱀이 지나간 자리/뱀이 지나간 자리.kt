import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	val(row, col) = readLine().split(' ').map{it.toInt()}
	val board = Array(row){ i ->
		if(i % 2 == 0)
			CharArray(col){'#'}
		else
			CharArray(col){'.'}
	}
	
	for(i in 1 until row step(2)){
		if(i % 4 == 1){
			board[i][col - 1] = '#'
		} else {
			board[i][0] = '#'
		}
	}
	val answer = StringBuilder()
	for(i in board){
		answer.append(i.joinToString("")).append('\n')
	}
	print(answer)
}