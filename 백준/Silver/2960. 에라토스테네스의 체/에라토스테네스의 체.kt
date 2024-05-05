import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val(num, del) = readLine()!!.split(' ').map(String::toInt)
    val isComposite = BooleanArray(num + 1)
    var ans = 0
    var cnt = 0
    for(i in 2..num) {
        if(!isComposite[i]) {
            var nums = i
            cnt++
            if(cnt == del)
                print(i)
            while(i * nums <= num){
                if(isComposite[i * nums]){
                    nums++
                    continue
                }
                isComposite[i * nums] = true
                cnt++
                if(cnt == del)
                    print(i * nums)
                nums++
            }
        }
    }
}