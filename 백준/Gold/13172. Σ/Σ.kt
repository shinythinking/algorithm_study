import java.util.*
import java.io.*

const val mod = 1_000_000_007
fun powByDQ(base: Int, exponent: Int): Long{
    if(exponent == 1)
        return base.toLong()

    val temp = powByDQ(base, exponent / 2)

    if(exponent % 2 == 0)
        return (temp * temp) % mod
    else
        return ((temp * temp) % mod * base) % mod

}

fun getGCD(a: Int, b: Int): Int {
    var left = a
    var right = b
    while(right != 0){
        val tmp = left % right
        left = right
        right = tmp
    }
    return left
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val num = readLine()!!.toInt()
    var sum = 0L

    for(i in 0 until num){
        var (n, s) = readLine().split(" ").map { it.toInt() }
        val gcd = getGCD(n, s)
        n /= gcd
        s /= gcd

        if(n == 1){
            sum += s.toLong()
            sum %= mod
            continue
        }

        sum += (s * powByDQ(n, mod - 2)) % mod
        sum %= mod
    }

    print(sum)
}