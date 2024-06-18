import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
	val (type, num) = readLine().split(' ').map{it.toInt()}
	val pocket = mutableSetOf<Int>()
	
	for(i in 1..num){
		val card = readLine().toInt()
		pocket.add(card)
		if(pocket.size == type){
			println(i)
			return
		}
	}
	println(-1)
}