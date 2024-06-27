import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
	val num = readLine().toInt()
	val board  = Array(num){
		readLine().split(' ').map{ it.toInt() }
	}
	var row = 0
	var col = 0
	
	for(i in board.indices){
		val temp = board[i].indexOf(0)
		if(temp != -1){
			row = i
			col = temp
			break
		}
	}
	
	var sum = 0
	for(i in 0 until num){
		sum += board[i][col]
		sum += board[row][i]
	}
	print(sum)
}