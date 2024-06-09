import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val input = readLine()
    val stack = ArrayDeque<Char>()
    val parMap = mapOf('[' to ']', '(' to ')')
    var weight = 1
    var answer = 0

    if(input.length % 2 != 0){
        print(0)
        return
    }

    var beforeOpen = false
    for(bracket in input){
        if(parMap.containsKey(bracket)){
            beforeOpen = true
            stack.push(bracket)
            weight *= if(bracket == '['){
                3
            } else {
                2
            }
        } else {
            if(stack.isEmpty()){
                print(0)
                return
            } else {
                if(parMap[stack.peek()] == bracket){
                    if(beforeOpen){
                        answer += weight
                        beforeOpen = false
                    }
                    stack.pop()
                    weight /= if(bracket == ')'){
                        2
                    } else {
                        3
                    }
                } else {
                    print(0)
                    return
                }
            }
        }
    }
    print(answer)
}