import java.io.*
import java.util.*

fun getLower(nums: List<Int>, target: Int): Int {
    var left = 0
    var right = nums.size
    while(left < right) {
        var mid = left + (right - left) / 2
        if(nums[mid] >= target) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val num = readLine().toInt()
    val nums = readLine().split(" ").map{ it.toInt() }.sorted()
    val target = readLine().toInt()
    val idx = getLower(nums, target)
    if(nums[idx] == target) {
        print(0)
        return
    }else if(idx == 0){
        print((nums[idx] - 2) + (target - 1) * (nums[idx] - target - 1))
    }else{
        print((nums[idx] - nums[idx - 1] - 2) + (target - nums[idx - 1] - 1) * (nums[idx] - target - 1))
    }
}