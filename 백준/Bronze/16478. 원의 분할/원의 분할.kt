fun main() {
    val (a , b , c) = readln().split(" ").map{it.toInt()}
    println(a*c/(b.toDouble()))
}