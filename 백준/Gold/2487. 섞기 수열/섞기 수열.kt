fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val cycles = mutableListOf<List<Int>>()
    val visited = BooleanArray(n + 1) { false }
    val pointing = mutableMapOf<Int, Int>()
    for ((idx, a) in arr.withIndex()) pointing.put(a, idx + 1)
    for (i in 1..n) {
        if (visited[i]) continue
        visited[i] = true
        val newCycle = mutableListOf(i)
        var next = pointing[i]!!
        while (!visited[next]) {
            visited[next] = true
            newCycle.add(next)
            next = pointing[next]!!
        }
        cycles.add(newCycle)
    }
    val nums = cycles.map { it.size }.filter { it != 1 }.toSet()
    var tmp = nums.first()
    for (num in nums) {
        val gcd = getGcd(tmp, num)
        tmp = num/ gcd * tmp 
    }

    println(tmp)
}

fun getGcd(a: Int, b: Int): Int {
    return if (b >= 1) getGcd(b, a % b) else a
}

