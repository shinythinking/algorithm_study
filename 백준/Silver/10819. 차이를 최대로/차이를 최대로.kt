import java.util.*
import java.io.*

var max = -1
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

    val num = readLine().toInt()
    val nums = readLine().split(' ').map{ it.toInt() }

    makeComb(nums, BooleanArray(num), intArrayOf())
    print(max)
}
fun makeComb(nums: List<Int>, visited: BooleanArray, comb: IntArray){
    if(comb.size == nums.size){
        var sum = 0
        for(i in 0 until comb.lastIndex){
            sum += Math.abs(comb[i] - comb[i + 1])
        }
        max = Math.max(max, sum)
    }

    for(i in 0..nums.lastIndex){
        if(visited[i])
            continue
        visited[i] = true
        makeComb(nums, visited, comb + nums[i])
        visited[i] = false
    }
}