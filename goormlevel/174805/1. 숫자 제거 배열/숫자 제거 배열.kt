
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
	val (num, k) = readLine().split(' ')
	val nums = readLine().split(' ').filter{ k !in it }.size
	println(nums)
}