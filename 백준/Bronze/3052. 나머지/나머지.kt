fun main() {
    val sets = mutableSetOf<Int>()
    repeat(10) {
        sets.add(readln().toInt() % 42)
    }
    println(sets.size)
}