import java.io.*
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`)) ) {

    val num = readLine().toInt()
    if(num <= 1){
        when (num) {
            1 -> print(3)
            else -> print(7)
        }
        return
    }
    var dp = IntArray(num)
    dp[0] = 3
    dp[1] = 7
    for(i in 2 until num){
        dp[i] = (2 * dp[i - 1] + dp[i - 2]) % 9901
    }
    print(dp[num - 1])
}
