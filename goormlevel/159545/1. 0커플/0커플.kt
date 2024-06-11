import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	val num = readLine()
	val attendants = readLine().split(' ').map{ it.toInt() }
	print(attendants.sum())
}