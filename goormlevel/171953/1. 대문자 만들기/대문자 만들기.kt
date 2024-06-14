import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
	val num = readLine().toInt()
	val str = readLine()
	var answer = ""
	for(ch in str){
		answer += if(ch in 'a'..'z'){
			(ch - 32).toChar()
		} else{
			ch
		}
	}
	print(answer)
}