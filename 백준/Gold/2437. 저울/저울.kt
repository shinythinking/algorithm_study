import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine().toInt()
    val weights = readLine().split(' ').map { it.toInt() }.sorted()

    var sum = 0
    if(weights[0] != 1){
        print(1)
        return
    }
    if(num == 1){
        print(2)
        return
    }
    for(i in 0 until weights.lastIndex){
        sum += weights[i]
        if(weights[i + 1] > sum + 1){
            print(sum + 1)
            return
        }
    }
    print(sum + 1 + weights.last())
}