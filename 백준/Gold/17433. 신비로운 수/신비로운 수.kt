fun main() {
    val reader = System.`in`.bufferedReader()
    val testcase = reader.readLine().toInt()
    val answer = buildString {
        repeat(testcase) {
            val num = reader.readLine().toInt()
            val lis = reader.readLine().split(" ").map { it.toInt() }.distinct()
            if(lis.size == 1) appendLine("INFINITY")
            else {
                val first = lis[0]
                val dif = lis.map{ Math.abs(it - first) }
                var tmp = dif[1]
                for(i in 2..dif.lastIndex) {
                    tmp = euclid(tmp, dif[i])
                }
                appendLine(tmp)
            }
        }
    }
    println(answer)
}

fun euclid(a: Int, b: Int): Int {
    var left = a
    var right = b
    while(right != 0) {
        val r = left % right
        left = right
        right = r
    }
    return left
}