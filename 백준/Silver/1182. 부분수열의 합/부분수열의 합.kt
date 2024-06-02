import java.io.*
import java.util.*

var answer = 0
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (num, target) = readLine().split(' ').map{ it.toInt() }
    val nums = readLine().split(' ').map{ it.toInt() }

    getComb(nums, target, 0, 0)
    if(target == 0)
        answer -= 1
    print(answer)
}

fun getComb(nums: List<Int>, target: Int, sum: Int, idx: Int){
    if(idx == nums.size) {
        if(sum == target)
            answer++
        return
    }

    getComb(nums, target, sum, idx + 1)
    getComb(nums, target, sum + nums[idx], idx + 1)


}