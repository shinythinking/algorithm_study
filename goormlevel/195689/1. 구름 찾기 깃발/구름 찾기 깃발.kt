fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
	val (size, target) = readLine().split(' ').map{ it.toInt() }
	val goormList = mutableListOf<Pair<Int, Int>>()
	val board = Array(size){
		readLine().split(' ').map{ it == "1" }
	}
	for(i in 0 until size){
		for(j in 0 until size){
			if(board[i][j])
				goormList.add(Pair(i, j))
		}
	}
	
	val goormMap = mutableMapOf<Pair<Int, Int>, Int>()
	
	val dRow = intArrayOf(1, -1, 0, 0, 1, 1, -1, -1)
	val dCol = intArrayOf(0, 0, 1, -1, -1, 1, 1, -1)
	
	for(goorm in goormList){
		for(i in 0 .. 7){
			val newR = goorm.first + dRow[i]
			val newC = goorm.second + dCol[i]
			
			if(newR < 0 || newC < 0 || newR >= size || newC >= size)
				continue
			if(board[newR][newC])
				continue
			goormMap[Pair(newR, newC)] = goormMap.getOrDefault(Pair(newR, newC), 0) + 1
		}
	}
	print(goormMap.values.count{ it == target })
	
}