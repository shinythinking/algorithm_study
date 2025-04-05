data class Node(
    val data: Int,
    var left: Node? = null,
    var right: Node? = null
)

fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val inOrder = reader.readLine().split(" ").map { it.toInt() }
    val postOrder = reader.readLine().split(" ").map { it.toInt() }

    fun divide(from: Int, to: Int, centerIdxOfPost: Int): Node? {
        if(from > to) return null
        val center = postOrder[centerIdxOfPost]

        if (from == to) return Node(center)
        val centerIdxOfIn = inOrder.indexOf(center)
        val amountOfR = to - centerIdxOfIn

        val left = divide(from, centerIdxOfIn - 1, centerIdxOfPost - amountOfR - 1)
        val right = divide(centerIdxOfIn + 1, to, centerIdxOfPost - 1)
        return Node(center, left, right)
    }

    fun getPreorder(node: Node?): String {
        val ans = buildString{
            fun traverse(node: Node?){
                if(node == null) return
                append("${node.data} ")
                traverse(node.left)
                traverse(node.right)
            }

            traverse(node)
        }
        return ans
    }

    val root = divide(0, num - 1, num - 1)
    println(getPreorder(root))
}