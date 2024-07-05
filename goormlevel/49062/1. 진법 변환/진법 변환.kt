fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
	val (from, to) = readLine().split(' ')
	val arr = to.map{
		if(it <= '9')
			it - '0'
		else 
			it - 'A' + 10
	}
	
	var answer = 0
	var start = 1 +  arr.max()!!
	
	for(i in start .. 16){
		var temp = from.toInt()
		for(j in arr.lastIndex downTo 0){
			if(arr[j] != (temp % i)){
				break
			} else  {
				temp /= i
			}
		}
		if (temp == 0){
			answer = i
			break
		}
	}
	print(answer)
}