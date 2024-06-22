import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val num = readLine().toInt()
    val nums = mutableListOf<String>()
    while (nums.size != num)
        nums.addAll(readLine().split(' '))

    val input = nums.joinToString("")
    var target = 0
    val setOfNum = mutableSetOf<Int>()
    var digit = 1
    while(true){
        for(i in 0 .. nums.size - digit){
            var tempNum = input.slice(i until i + digit).toInt()
            setOfNum.add(tempNum)
            while(setOfNum.contains(target)){
                target++
            }
        }
        if(target == Math.pow(10.0, digit.toDouble()).toInt()){
            digit++
            setOfNum.clear()
        } else {
            break
        }
    }
    print(target)

}