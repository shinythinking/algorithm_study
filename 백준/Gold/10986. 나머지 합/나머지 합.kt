
fun main() {
    val reader = System.`in`.bufferedReader()
    val (num, target) = reader.readLine().split(" ").map { it.toInt() }
    val nums = reader.readLine().split(" ").map { it.toInt() % target }
    val sums = IntArray(num)
    val remains = LongArray(target)

    sums[0] = nums[0] % target
    remains[sums[0]]++

    for (i in 1 until num) {
        sums[i] = (sums[i - 1] + nums[i]) % target
        remains[sums[i]]++
    }

    var answer = remains[0]

    for(i in remains.indices) {
        answer += remains[i] * (remains[i] - 1) / 2
    }
    println(answer)
}