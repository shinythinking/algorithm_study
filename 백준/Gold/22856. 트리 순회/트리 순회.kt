class EarlyReturn(val result: Int) : Exception()

fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine()!!.toInt()
    val tree = IntArray(2 * (n + 1)){-1}
    tree[1] = 1
    repeat(n) {
        val (current, left, right) = reader.readLine()!!.split(" ").map { it.toInt() }
        tree[current * 2] = left
        tree[current * 2 + 1] = right
    }
    var answer = 0
    var cnt = 0


    fun traverseHelper(cur: Int) {
        if(tree[cur * 2] != -1) {
            answer++
            traverseHelper(tree[cur * 2])
        }
        cnt++
        if(tree[cur * 2 + 1] != -1) {
            answer++
            traverseHelper(tree[cur * 2 + 1])
        }

        if(cnt == n) {
            throw EarlyReturn(answer)
        }

        answer++
    }
    fun traverse(cur: Int): Int {
        try {
            traverseHelper(cur)
            return answer // 정상적으로 끝난 경우
        } catch (e: EarlyReturn) {
            return e.result
        }
    }

    println(traverse(1))
}