import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val num = readLine().toInt()
    val initialTemp = readLine().split(' ').map{ it.toInt() }
    val targetTemp = readLine().split(' ').map{ it.toInt() }
    val amountTemp = readLine().split(' ').map{ it.toInt() }
    
    val diffTemp = IntArray(num){ i ->
        Math.abs(targetTemp[i] - initialTemp[i])
    }
    
    var flagForOdd = false
    var flagForEven = false
    
    var answer = 0
    
    for(i in diffTemp.indices){
        if(diffTemp[i] % amountTemp[i] != 0){
            print(-1)
            return
        }
        if(flagForOdd && flagForEven){
            print(-1)
            return
        }
        
        var distance = diffTemp[i] / amountTemp[i]
        answer = Math.max(answer, distance)
        
        if(distance % 2 == 0)
            flagForEven = true
        else
            flagForOdd = true
    }
    
    print(answer)
}