fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val lines = Array(num) {
        val input = reader.readLine().split(" ").map { it.toInt() }
        input[0] to input[1]
    }.sortedBy { it.first }
    var lastIndex = 1

    val dp = IntArray(num + 1)
    for(line in lines){
        var left = 0
        var right = lastIndex
        while(right > left) {
            val mid = (left + right) / 2
            if(dp[mid] < line.second){
                left = mid + 1
            }else{
                right = mid
            }
        }
        dp[left] = line.second
        if(left == lastIndex) lastIndex++
    }
    println(num - lastIndex + 1)

}