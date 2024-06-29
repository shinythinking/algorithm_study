fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
	val (num, m) = readLine().split(' ').map{ it.toInt() }
	val nums = readLine().split(' ').map{ 
		val temp = it.toInt()
		if(temp % m == 0)
			temp
		else 
			temp * m
	}.joinToString(" ")
	print(nums)
}