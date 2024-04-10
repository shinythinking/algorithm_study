import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
   var testCase = readLine().toInt()
   var answers = StringBuilder()

   while(testCase --> 0){
      val num = readLine().toInt()
      val input = readLine().split(" ").map { it.toLong() }
      var answer = 0L

      var idx = input.lastIndex
      while(idx > 0){
         for(i in idx - 1 downTo 0){
            if(input[idx] >= input[i]){
               answer += input[idx] - input[i]

            } else {
               idx = i
               break
            }
            if(i == 0)
               idx = 0
         }

      }

      answers.append(answer).append('\n')
   }

   print(answers)
}