import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	val (left, right) = readLine().split(' ')
	val l = left.reversed().trimStart('0').toInt()
	val r = right.reversed().trimStart('0').toInt()
	print(if(l <= r) right else left)
}