import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

    var (fruitsNum, initH) = readLine().split(" ").map { it.toInt() }
    var heights = readLine().split(" ").map { it.toInt() }
    heights = heights.sorted()

    for(height in heights){
        if(initH >= height){
            initH++
        } else
            break
    }
    print(initH)
}
   