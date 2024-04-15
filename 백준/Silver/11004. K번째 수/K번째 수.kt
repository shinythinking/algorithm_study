import java.util.*
import java.io.*
import kotlin.collections.List

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (num, targetIdx) = readLine().split(" ").map { it.toInt() }
    var numArr = readLine().split(" ").map { it.toInt() }
    numArr = numArr.sorted()
    print(numArr[targetIdx - 1])
}
   