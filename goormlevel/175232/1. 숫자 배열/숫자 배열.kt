fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
	val num = readLine().toInt()
	var answer = StringBuilder()
	var idx = 1
	for(i in 1 .. num){
		for(j in 1 .. num){
			answer.append(idx++).append(' ')
		}
		answer.setLength(answer.length - 1)
		answer.append('\n')
	}
	
	print(answer.trimEnd())
}