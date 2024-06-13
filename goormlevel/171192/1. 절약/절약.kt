import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	var num = readLine().toInt()
	var sum = 0L
	var isSuccess = true
	while(num --> 0){
		val(type, amount) = readLine()!!.split(' ')
		if(isSuccess){
			sum += when(type){
				"in" -> amount.toLong()
				else -> - amount.toLong()
			}
			
			if(sum < 0)
				isSuccess = false
		}
	}
	print(if(isSuccess) "success" else "fail")
	
}