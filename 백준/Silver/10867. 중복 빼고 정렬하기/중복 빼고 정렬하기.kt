import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine().toInt()
    print(readLine().split(" ").map(String::toInt).toSortedSet().joinToString(" "))
}