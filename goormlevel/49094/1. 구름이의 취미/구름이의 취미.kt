import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
	var num1 = readLine().toLong()
	var num2 = num1 + 1L
	if(num1 % 2 == 0L){
		num1 /= 2
	} else {
		num2 /= 2
	}
	
	val temp = (num1 * num2) % 1000000007L
	print((temp * temp) % 1000000007L)
}