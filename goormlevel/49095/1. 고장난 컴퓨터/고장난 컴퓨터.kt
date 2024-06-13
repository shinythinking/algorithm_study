import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	val (num, time) = readLine().split(' ').map{it.toInt()}
	val times = readLine().split(' ').map{it.toInt()}
	
	var cnt = 1
	var startIdx = times.lastIndex - 1
	var start = times.last() - time
	while(startIdx >= 0){
		if(start <= times[startIdx]){
			start = times[startIdx] - time
			startIdx--
			cnt++
		} else{
			break
		}
	}
	print(cnt)
}