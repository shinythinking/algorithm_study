import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	val num = readLine().toInt()
	var sum = 1L
	if(num >= 6){
		print(9)
		return
	}
	for(i in 2..num){
		sum *= i
		if(sum % 10 == 0L)
			sum /= 10
	}
	var temp = sum.toString()
	while(temp.length != 1 ){
		var numTemp = 0
		for(ch in temp){
			numTemp += ch - '0'
		}
		temp = numTemp.toString()
	}
	print(temp)
}