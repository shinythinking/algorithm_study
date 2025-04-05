
import java.math.BigInteger
import java.util.*
import kotlin.math.pow

fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()

    fun hanoiString(target: Int): String {
        return buildString {
            fun hanoi(target: Int, from: Int, to: Int, asc: Int) {
                if (target == 1) {
                    appendLine("$from $to")
                    return
                }
                val t = target - 1
                hanoi(t, from, asc, to)
                appendLine("$from $to")
                hanoi(t, asc, to, from)
            }
            hanoi(target, 1, 3, 2)
        }
    }

    val result = BigInteger.valueOf(2).pow(num)
    println(result - BigInteger.ONE)
    if (num <= 20) {
        println(hanoiString(num))
    }

}