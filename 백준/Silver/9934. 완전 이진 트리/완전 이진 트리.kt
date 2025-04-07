fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val inorder = reader.readLine().split(" ").map { it.toInt() }
    val answer = Array(num) {
        mutableListOf<Int>()
    }
    fun inorderTo(from: Int, to: Int, num: Int) {
        if(from > to) return
        val mid = (from + to) / 2

        answer[num].add(inorder[mid])
        if(from == to) return
        inorderTo(from, mid - 1, num + 1)
        inorderTo(mid + 1, to, num + 1)
    }
    inorderTo(0, inorder.lastIndex, 0)
    println(answer.joinToString("\n"){ it.joinToString(" ") })
}