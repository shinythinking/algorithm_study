package shinythinking

val idxList = mutableListOf<Int>()

fun main() {
    val size = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }.toMutableList()
    val alter = readln().toInt()
    nums[nums.indexOf(-1)] = alter
    nums.sort()

    preOrderTraversal(size / 2, (size + 1) / 4)
    val answer = buildString{
        idxList.forEach {
            append("${nums[it]} ")
        }
    }
    println(answer)
}

fun preOrderTraversal(idx: Int, dist: Int) {
    if (dist == 0) {
        idxList.add(idx)
        return
    }

    preOrderTraversal(idx - dist, dist/ 2)
    preOrderTraversal(idx + dist, dist/ 2)
    idxList.add(idx)
}