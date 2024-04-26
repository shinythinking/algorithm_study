import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`)))  {
    val answer = StringBuilder()
    val regex = "^[^aeiou]+$|.*[aeiou]{3,}.*|.*[^aeiou]{3,}.*|.*([^eo])\\1+.*".toRegex()
    while (true) {
        val input = readLine()
        if(input == "end")
            break
        answer.append('<').append(input)
        if(input.matches(regex)){
            answer.append("> is not acceptable.").append("\n")
        }else{
            answer.append("> is acceptable.").append("\n")
        }

    }
    print(answer)

}