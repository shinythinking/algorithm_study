import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
   val sensor = readLine().toInt()
   val receiver = readLine().toInt()
   var sensorPos = readLine().split(" ").map { it.toInt() }

   var answer = 0
   sensorPos = sensorPos.sorted()

   var dif = mutableListOf<Int>()
   for(i in 0 until sensorPos.lastIndex) {
      dif += sensorPos[i + 1] - sensorPos[i]
   }

   val diffs = dif.sorted()

   for(i in 0..((dif.lastIndex - receiver) + 1)){
      answer += diffs[i]
   }

   print(answer)
}