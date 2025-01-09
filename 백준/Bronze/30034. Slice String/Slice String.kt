fun main() {
    val numOfSplitChar = readln().toInt()
    val listOfSplitChars = readln().split(" ").toSet()
    val numOfSplitInt = readln().toInt()
    val listOfSplitInt = readln().split(" ")
    val numOfException = readln().toInt()
    val listOfException = readln().split(" ").toSet()
    val length = readln().toInt()
    val setOfSplit = (listOfSplitChars + listOfSplitInt - listOfException + " ").toTypedArray()
    println(readln().split(*setOfSplit).filter { it.isNotBlank() }.joinToString("\n"))
}