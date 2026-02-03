
fun main() {
    val n = readln()
    val nums = readln().split(" ").map{it.toInt()}.sorted()
    val avg = nums.average()

    val second =  if(nums.size <= 1) nums.last() else nums[nums.lastIndex-1]

    val ans = if(avg > second) avg else second
    println(ans)
}