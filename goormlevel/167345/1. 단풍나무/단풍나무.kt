fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
	var size = readLine().toInt()
	
	val originMap = mutableMapOf<Pair<Int, Int>, Int>()
	val nextMap = mutableMapOf<Pair<Int, Int>, Int>()
	
	for(i in 0 until size){
		val row = readLine().split(' ').map{ it.toInt() }
		for((j, r) in row.withIndex()){
			if(r == 0)
				continue
			originMap[Pair(i, j)] = r
		}
	}
	
	var answer = 0
	
	val dRow = intArrayOf(1, -1, 0, 0)
	val dCol = intArrayOf(0, 0, 1, -1)
	
	while(originMap.isNotEmpty()){
		for(entry in originMap){
			val r = entry.key.first
			val c = entry.key.second
			var remain = entry.value
			
			for(i in 0..3){
				val newR = r + dRow[i]
				val newC = c + dCol[i]
				if(newR < 0 || newC < 0 || newR >= size || newC >= size)
					continue
				if(!originMap.contains(Pair(newR, newC)))
					remain--
				
				if(remain == 0)
					break
			}
			if(remain > 0)
				nextMap.put(Pair(r, c), remain)
		}
		originMap.clear()
		originMap.putAll(nextMap)
		nextMap.clear()
		answer++
	}
	
	
	print(answer)
}