import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	val (left, right) = readLine().split(' ')
	val leftS = left.reversed().toInt()
	val rightS = right.reversed().toInt()
	
	print(if(leftS >= rightS) left else right)
}