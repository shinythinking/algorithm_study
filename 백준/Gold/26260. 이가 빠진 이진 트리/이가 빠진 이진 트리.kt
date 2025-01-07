val idxList = mutableListOf<Int>()

fun main() {
    val size = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }.toMutableList()
    val alter = readln().toInt()
    nums[nums.indexOf(-1)] = alter
    nums.sort()

    postOrder(0, nums.size)
    val answer = buildString{
        idxList.forEach {
            append("${nums[it]} ")
        }
    }
    println(answer)
}

fun postOrder(s: Int, e: Int) {
    val m = (s + e) / 2
    if(s < e) {
        postOrder(s, m)
        postOrder(m + 1, e)
        idxList.add(m)
    }
}