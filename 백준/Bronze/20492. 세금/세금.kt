fun main() {
    val reader = System.`in`.bufferedReader()
    val input = reader.readLine().toInt()
    println("${(input * 0.78).toInt()} ${(input * 0.956).toInt()}")
}