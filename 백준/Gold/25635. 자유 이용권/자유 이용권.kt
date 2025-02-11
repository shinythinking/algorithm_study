fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val nums = reader.readLine().split(" ").map { it.toLong() }
    val max = nums.max()
    val others = nums.sum() - max
    if(max - 1 <= others) {
        println(max + others)
    } else {
        println(others * 2 + 1)
    }
}