import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val num = readLine().toInt()
    val switches = readLine().split(' ').map{ it == "1" }.toMutableList()
    switches.add(0, true)
    var students = readLine().toInt()

    while(students --> 0){
        val(gender, number) = readLine()!!.split(' ').map{ it.toInt() }

        switches[number] = !switches[number]

        if(gender == 1){
            for(i in 2..(num / number)){
                val temp = number * i
                switches[temp] = !switches[temp]
            }
        }else{
            var step = 1
            while(number - step > 0 && number + step <= num){

                if(switches[number - step] != switches[number + step])
                    break
                if(switches[number - step]){
                    switches[number - step] = false
                    switches[number + step] = false
                } else {
                    switches[number - step] = true
                    switches[number + step] = true
                }
                step++
            }
        }
    }
    val answer = switches.map{if(it) 1 else 0}.toMutableList()

    val ans = StringBuilder()

    for(i in 1..answer.lastIndex){
        
        ans.append(answer[i]).append(' ')
        if(i % 20 == 0)
            ans.append('\n')
    }
    print(ans)
}