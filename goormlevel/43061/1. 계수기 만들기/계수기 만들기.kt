fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
	val num = readLine().toInt()
	val limit = readLine().split(' ').map{ it.toInt() + 1 }
	val input = readLine().split(' ').map{ it.toInt() }.toMutableList()
	var carry = readLine().toInt()
	
	for(i in input.lastIndex downTo 0){
		val temp = input[i] + carry
		input[i] = temp % limit[i]
		carry = temp / limit[i]
		if(carry <= 0)
			break
	}
	print(input.joinToString(""))
	
}