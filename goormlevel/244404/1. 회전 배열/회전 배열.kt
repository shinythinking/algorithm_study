import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	var (length, target) = readLine().split(' ').map{ it.toInt() }
	val nums = readLine().split(' ').map{ it.toInt() }
	
	var idx = 0
	while(target --> 0){
		idx += (nums[idx] % length)
		idx %= length
	}
	print(nums[idx])
}