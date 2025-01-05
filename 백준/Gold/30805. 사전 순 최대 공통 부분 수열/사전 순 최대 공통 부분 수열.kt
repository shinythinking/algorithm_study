
fun main() {
    val answer = mutableListOf<Int>()
    val numOfA = readln().toInt()
    var listA = readln().split(" ").map { it.toInt() }.toMutableList()
    val numOfB = readln().toInt()
    var listB = readln().split(" ").map { it.toInt() }.toMutableList()

    while(listA.size != 0 && listB.size != 0) {
        val common = findCommonBiggest(listA, listB)
        if(common == -1) break
        answer.add(common)

        listA = listA.subList(listA.indexOf(common) + 1, listA.size)
        listB = listB.subList(listB.indexOf(common) + 1, listB.size)
    }

    println(answer.size)
    if(answer.size != 0) {
        println(answer.joinToString(" "))
    }
}

fun findCommonBiggest(listA: List<Int>, listB: List<Int>): Int {
    val sortedSetA = listA.toSortedSet(reverseOrder())
    val sortedSetB = listB.toSortedSet(reverseOrder())
    while (sortedSetA.size != 0 && sortedSetB.size != 0) {
        val a = sortedSetA.first()
        val b = sortedSetB.first()

        if(a == b) {
            return a
        } else if(a > b){
            sortedSetA.remove(a)
        } else {
            sortedSetB.remove(b)
        }
    }
    return -1
}

fun combination(n: Int, k: Int): Int {
    if (k == 0 || k == n) return 1
    var result = 1
    for (i in 1..k) {
        result = result * (n - i + 1) / i
    }
    return result
}