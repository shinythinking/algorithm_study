fun main() {
    val reader = System.`in`.bufferedReader()
    var answer = 0
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val nList = List<String>(n){
        reader.readLine()
    }.sorted()
    repeat(m) {
        val str = reader.readLine()
        var left = 0
        var right = nList.lastIndex
        while(left <= right){
            val mid = (left + right) / 2
            if (nList[mid].startsWith(str)){
                answer ++
                break
            } else if (nList[mid] > str){
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
    }
    println(answer)
}