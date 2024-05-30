import java.util.*
import java.io.*

fun sum(nums: List<Int>, op: MutableList<Int>, depth: Int, tmp: Int){
    if(depth == nums.size){
        sums.add(tmp)
        return
    }

    for((i, left) in op.withIndex()){
        if(left == 0)
            continue
        op[i] = left - 1
        when(i){
            0 -> sum(nums, op, depth + 1 ,tmp + nums[depth])
            1 -> sum(nums, op, depth + 1 ,tmp - nums[depth])
            2 -> sum(nums, op, depth + 1 ,tmp * nums[depth])
            else -> sum(nums, op, depth + 1 ,tmp / nums[depth])
        }
        op[i] = left
    }
}

val sums = mutableListOf<Int>()
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine().toInt()
    val nums = readLine().split(' ').map{ it.toInt() }
    val op = readLine().split(' ').map{ it.toInt() }.toMutableList()

    sum(nums, op, 1, nums[0])
    sums.sort()
    print("${sums.last()}\n${sums[0]}")
}