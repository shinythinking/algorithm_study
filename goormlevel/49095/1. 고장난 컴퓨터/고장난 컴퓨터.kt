import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
	val(num, time) = readLine().split(' ').map{ it.toInt() }
	var answer = 1
	val times = readLine().split(' ').map{it.toInt()}
	var start = times[num - 1] - time
	for(i in times.lastIndex - 1 downTo 0){
		if(times[i] < start)
			break
		
		answer++
		start = times[i] - time
	}
	print(answer)
}