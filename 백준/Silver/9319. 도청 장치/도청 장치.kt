import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var testcase = readLine().toInt()
    val answer = StringBuilder()

    while(testcase --> 0){
        val device = readLine().toInt()
        val noise =  readLine().toInt() * 6
        val (lx, ly) = readLine().split(' ').map{ it.toInt() }

        if(device == 0){
            answer.append("NOISE").append('\n')
            continue
        }
        val receivePower = DoubleArray(device){
            val (x, y, strength) = readLine().split(' ').map{ it.toInt() }
            strength * 6.0 / ((lx - x) * (lx - x) + (ly - y) * (ly - y) )
        }

        var maxReceive = receivePower.max()
        var maxIdx = receivePower.indexOfFirst{ it == maxReceive } + 1
        val sumOfRest = receivePower.sum() - maxReceive
        maxReceive /= 6.0

        if(maxReceive > sumOfRest + noise){
            answer.append(maxIdx).append('\n')
        } else {
            answer.append("NOISE").append('\n')
        }
    }
    print(answer)
}