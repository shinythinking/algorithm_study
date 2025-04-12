fun main() {
    val reader = System.`in`.bufferedReader()
    val input = reader.readLine().toInt()
    val statement = reader.readLine()
    val alphabet = DoubleArray(input) {
        reader.readLine().toDouble()
    }
    val stack = ArrayDeque<Double>()
    for (i in statement.indices) {
        when (statement[i]) {
            '*' -> {
                val v1 = stack.removeLast()
                val v2 = stack.removeLast()
                stack.addLast(v2 * v1)
            }

            '/' -> {
                val v1 = stack.removeLast()
                val v2 = stack.removeLast()
                stack.addLast(v2 / v1)
            }

            '+' -> {
                val v1 = stack.removeLast()
                val v2 = stack.removeLast()
                stack.addLast(v2 + v1)
            }

            '-' -> {
                val v1 = stack.removeLast()
                val v2 = stack.removeLast()
                stack.addLast(v2 - v1)
            }

            else -> {
                stack.addLast(alphabet[statement[i] - 'A'])
            }
        }
    }
    println(String.format("%.2f", stack.removeLast()))
}