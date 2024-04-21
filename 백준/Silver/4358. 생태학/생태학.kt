import java.util.*
import java.io.*
import java.time.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

fun main(args: Array<String>)  {

    var br = BufferedReader(InputStreamReader(System.`in`))
    /*
    val num = br.readLine().toInt()
    val table = mutableMapOf<Int, Int>()
    for(i in 0 until num){
        val (from, to) = br.readLine().split(" ").map { it.toInt() }
        if(table.containsKey(from)){
            table[from] = Math.max(from, table[from]!!)
        } else {
            table[from] = to
        }
    }

    val keyList = table.keys.sorted()
    var from  = Int.MIN_VALUE
    var to = Int.MIN_VALUE
    var answer = 0
    for(key in keyList){
        if(to < key){
            answer += to - from
            from = key
            to = table[key]!!
        } else {
            to = Math.max(to, table[key]!!)
        }
    }
    answer += to - from
    print(answer) */

    val answer = StringBuilder()
    val sc = Scanner(System.`in`)
    val dict = TreeMap<String, Int>()
    var cnt = 0
    while(true){
        val str = br.readLine() ?: break
        if (str.isBlank()) {
            break
        }
        cnt++
        dict[str] = dict.getOrDefault(str, 0) + 1
    }
    for(map in dict){
        var num = (dict[map.key]?.toDouble() ?: 0.0) / cnt.toDouble()
        num = Math.round(num * 1000000) / 10000.0
        val anum = String.format("%.4f", num)
        answer.append("${map.key} ${anum}").append('\n')
    }
    print(answer)
}
/*
fun majorityElement(nums:IntArray): Int{
    fun majorityElement(left: Int, right: Int, nums: IntArray): Int{
        if(left == right)
            return nums[left]

        val mid = left + (right - left) / 2
        val a = majorityElement(left, mid, nums)
        val b = majorityElement(mid + 1, right, nums)
        var countA = 0

        for(i in left..right){
            if(nums[i] == a)
                countA++
        }

        return if(countA > (right - left + 1) / 2)
            a
        else
            b
    }
}*/
