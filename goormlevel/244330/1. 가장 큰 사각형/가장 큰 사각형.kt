import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
	var num = readLine().toInt()
	var answer = 0
	while(num --> 0){
		val(width, height) = readLine().split(' ').map{ it.toInt() }
		answer = Math.max(answer, width * height)
	}

	print(answer)
}