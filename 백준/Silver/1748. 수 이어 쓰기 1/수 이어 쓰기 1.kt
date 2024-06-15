import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val num = readLine()
    var len = num.length
    val end = Math.pow(10.0, (len - 1).toDouble()).toInt()

    var cnt = 0
    cnt += len * (num.toInt() - end + 1)

    for(i in 0 until len - 1){
        cnt += 9 * Math.pow(10.0, i.toDouble()).toInt() * (i + 1)
    }
    print(cnt)
}