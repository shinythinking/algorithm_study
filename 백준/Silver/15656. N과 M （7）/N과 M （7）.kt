import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val (num, choice) = reader.readLine()!!.split(" ").map { it.toInt() }
    val nums = reader.readLine()!!.split(" ").map { it.toInt() }.sorted()
    fun permutate(permutation: MutableList<String>, curList: List<Int>) {
        if(curList.size == choice) {
            permutation.add(curList.joinToString(" "))
            return
        }
        for(num in nums) {
            permutate(permutation, curList + num)
        }
    }
    val ans = mutableListOf<String>()
    permutate(ans, mutableListOf())
    println(ans.joinToString("\n"))
}