
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
	val input = readLine().toInt()
	val arr = readLine().split(' ')
	val target = readLine()
	var cnt = 0
	for(a in arr){
		if(a == target)
			cnt++
	}
	
	print(cnt)
}