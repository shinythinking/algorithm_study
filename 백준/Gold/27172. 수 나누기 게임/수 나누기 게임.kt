fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()
    val nums = reader.readLine().split(" ").map { it.toInt() }
    val max = nums.max()
    val answer = IntArray(n)
    val sieve = IntArray(max + 1) { -1 }
    for ((i, num) in nums.withIndex()) {
        sieve[num] = i
    }

    for (num in nums) {
        val tmp = num + num
        for (i in tmp..max step num) {
            if (sieve[i] != -1) {
                answer[sieve[num]]++
                answer[sieve[i]]--
            }
        }
    }
    println(answer.joinToString(" "))
}