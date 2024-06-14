import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
	var num = readLine().toInt()
	val answer = StringBuilder()
	val regex = "[^aeiouAEIOU]".toRegex()
	
	while(num --> 0){
		val str = readLine().replace(regex, "")
		answer.append(if(str.length == 0){
			"???"
		}else {
			str
		}).append('\n')
	}
	print(answer)
}