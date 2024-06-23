import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val num  = readLine()
    val earn = readLine().split(' ').map{ it.toInt() }
    val loss = readLine().split(' ').map{ it.toInt() }
    val ratio = readLine().split(' ').map{ (it.toDouble() * 10).toInt() }

    var sum = 0L

    for((i, r) in ratio.withIndex()){
        sum += if(r >= 10){
            (earn[i] * r) / 10 - loss[i]
        } else {
            earn[i] - (loss[i] * r) / 10
        }
    }

    print(sum)
}