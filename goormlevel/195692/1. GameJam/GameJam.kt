lateinit var board: Array<List<String>>

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
	val size = readLine().toInt()
	
	var (rowG, colG) = readLine().split(' ').map{ it.toInt() - 1 }
	var (rowP, colP) = readLine().split(' ').map{ it.toInt() - 1 }
	
	board = Array(size){
		readLine().split(' ')
	}
	
	val cntOfG = playGame(rowG, colG)
	val cntOfP = playGame(rowP, colP)
	
	if(cntOfG > cntOfP){
		print("goorm $cntOfG")
	} else {
		print("player $cntOfP")
	}
}

fun playGame(row: Int, col: Int): Int{
	val visited = Array(board.size){ BooleanArray(board.size) }
	var cnt = 1
	visited[row][col] = true
	
	var playerR = row
	var playerC = col
	
	val dRow = intArrayOf(0, 0, board.lastIndex, 1)
	val dCol = intArrayOf(board.lastIndex, 1, 0, 0)
	
	while(true){
		val order = board[playerR][playerC]
		var move = order.dropLast(1).toInt()
		val direction = when(order[order.lastIndex]){
			'L' -> 0 
			'R' -> 1
			'U' -> 2
			else -> 3
		}
		
		while(move --> 0){
			playerR += dRow[direction]
			playerC += dCol[direction]
			
			playerR %= board.size
			playerC %= board.size
			
			if(visited[playerR][playerC]){
				move = -2
				break
			}
			visited[playerR][playerC] = true
			
			cnt++
		}
		
		if(move == -2)
			break
	}
	return cnt
}









