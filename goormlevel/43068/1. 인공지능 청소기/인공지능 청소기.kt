import java.io.*
import java.util.*

fun main(args: Array<String>) {
	val answer = StringBuilder()
	var testcase = readLine()!!.toInt()
	
	while(testcase --> 0){
		val(row, col, time) = readLine()!!.split(' ').map{ it.toInt() }
		val temp = time - Math.abs(row) - Math.abs(col)
		val ans = if(temp < 0 || temp % 2 != 0){
			"NO"
		} else {
			"YES"
		}
		answer.append(ans).append('\n')
	}
	print(answer)
}