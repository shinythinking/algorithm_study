import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	var num = readLine().toInt()
	val answer = StringBuilder()
	val regex = "[^AEIOUaeiou]".toRegex()
	
	while(num --> 0){
		val str = readLine().replace(regex, "")
		if(str.length == 0){
			answer.append("???").append('\n')
		}else{
			answer.append(str).append('\n')	
		}
	}
	print(answer)
}