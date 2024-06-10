import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	
	val input = readLine().split(' ').map{ it.toInt() }.sorted()
	print(input[3] - input[0] + input[2] - input[1])
	
}