fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val set = mutableSetOf<String>()
    set.add("ChongChong")
    repeat(num) {
        val (h1, h2) = reader.readLine()!!.split(' ')
        if(set.contains(h1) || set.contains(h2)) {
            set.add(h1)
            set.add(h2)
        }
    }
    println(set.size)
}