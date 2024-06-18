import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
	val (len, bomb) = readLine().split(' ').map{ it.toInt() }
	val stackForChar = ArrayDeque<Char>()
	
	val stackForCnt = ArrayDeque<Int>()
	
	val input = readLine()
	var cnt = 1
	stackForChar.push(input[0])
	for(i in 1 .. input.lastIndex){
		if(stackForChar.peek() == input[i]){
			cnt++
		} else {
			if(cnt >= bomb){
				stackForChar.pop()
				if(input[i] == stackForChar.peek() ?: '-'){
					cnt = stackForCnt.pop() + 1
				} else {
					cnt = 1
					stackForChar.push(input[i])
				}
			} else {
				stackForCnt.push(cnt)
				cnt = 1
				stackForChar.push(input[i])
			}
		}
	}
	val answer = StringBuilder()
	
	if(cnt >= bomb){
		stackForChar.pop()
	} else {
		val str = stackForChar.pop().toString()
		answer.append(str.repeat(cnt))
	}
	
	while(stackForCnt.isNotEmpty()){
		cnt = stackForCnt.pop()
		val chars = stackForChar.pop().toString()
		answer.append(chars.repeat(cnt))
	}
	
	
	println(if(answer.length == 0){
		"CLEAR!"
	}else {
		answer.reversed()
	})
}
