import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val input = reader.readLine()
    var prevP = 0
    var i = 0
    if(input.length < 4 || input.last() == 'A') {
        if(input == "P"){
            println("PPAP")
        } else {
            println("NP")
        }
        return
    }
    while (i < input.length) {
        if(input[i] == 'P') {
            prevP++
        } else if(input[i] == 'A') {
            if(prevP < 2) {
                println("NP")
                return
            } else {
                if(input[i + 1] != 'P') {
                    println("NP")
                    return
                }
                i++
                prevP --
            }
        } else {
            println("NP")
            return
        }
        i++
    }
    if(prevP != 1) {
        println("NP")
    } else {
        println("PPAP")
    }
}