fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
	var (size, num) = readLine().split(' ').map{ it.toInt() }
	
	val status = Array(size){
		readLine().split(' ')
	}
	
	val ground = Array(size){
		IntArray(size)
	}
	
	val dRow = intArrayOf(1, -1, 0, 0, 0)
	val dCol = intArrayOf(0, 0, 1, -1, 0)
	
	var answer = 0
	
	repeat(num){
		val (r, c) = readLine().split(' ').map{ it.toInt() - 1 }
		for(i in 0 .. 4){
			val newR = r + dRow[i]
			val newC = c + dCol[i]
			if(newR < 0 || newC < 0 || newR >= size || newC >= size)
				continue
			ground[newR][newC] += when(status[newR][newC]){
				"#" -> continue
				"0" -> 1
				else -> 2
 			}
			answer = Math.max(ground[newR][newC], answer)
		}
	}
	print(answer)
}