import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val nums = Array<String>(num) {
        reader.readLine()
    }
    val divider = reader.readLine().toInt()
    val ten = 10 % divider
    val afters = nums.map {
        var tmp = 0
        if (it.length > 9) {
            for (ch in it) {
                tmp *= ten
                tmp += (ch - '0') % divider
                tmp %= divider
            }
        } else {
            tmp = it.toInt()
            tmp %= divider
        }
        tmp
    }
    val pow10Mod = IntArray(51) { 1 }
    for (i in 1..50) {
        pow10Mod[i] = (pow10Mod[i - 1] * 10) % divider
    }

    val dp = Array(1 shl num) {
        LongArray(divider) { -1L }
    }

    dp[0][0] = 1
    for (i in dp.indices) {
        for (j in 0 until divider) {
            if (dp[i][j] == -1L) continue

            for (k in 0 until num) {
                if (i and (1 shl k) != 0) continue
                
                val newVisit = i or (1 shl k)
                val newRemain = (j * pow10Mod[nums[k].length] + afters[k]) % divider
                if (dp[newVisit][newRemain] == -1L) dp[newVisit][newRemain] = 0
                dp[newVisit][newRemain] += dp[i][j]
            }
        }
    }

    val answer = dp[(1 shl num) - 1][0]
    if (answer == -1L) {
        println("0/1")
        return
    }
    var dividend = 1L
    for (i in 2..num) dividend *= i

    val gcd = euclid(answer, dividend)

    println("${answer / gcd}/${dividend / gcd}")
}

fun euclid(a: Long, b: Long): Long {
    var left = a
    var right = b
    while (right != 0L) {
        val r = left % right
        left = right
        right = r
    }
    return left
}
