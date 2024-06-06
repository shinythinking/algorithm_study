import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

    val(num, seq) = readLine().split(' ').map { it.toInt() }
    val temperature = readLine().split(' ').map { it.toInt() }

    var sum = 0
    for(i in 0 until seq)
        sum += temperature[i]

    var max = sum
    for(i in seq until num){
        sum += temperature[i]
        sum -= temperature[i -seq]
        max = Math.max(sum, max)
    }
    print(max)
}