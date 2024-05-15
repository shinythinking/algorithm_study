import java.util.*
import java.io.*

fun findLower(target: Int, powerTwo: IntArray): Int{
    var left = 0
    var right = powerTwo.size
    while(left < right){
        val mid = (left + right) / 2
        if(target < powerTwo[mid])
            right = mid
        else
            left = mid + 1
    }
    return left
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var(N, K) = readLine()!!.split(' ').map { it.toInt() }

    if(N <= K){
        print(0)
        return
    }
    val powerTwo = IntArray(25).mapIndexed{ i, c -> Math.pow(2.0, i.toDouble()).toInt() }.toIntArray()
    
    while(N > 1 && K != 1){
        N -= powerTwo[findLower(N, powerTwo) - 1]
        K--
    }
    if(N <= 1)
        print(0)
    else if(K == 1){
        if(N in powerTwo)
            print(0)
        else
            print(powerTwo[findLower(N, powerTwo)] - N)
    }
}
