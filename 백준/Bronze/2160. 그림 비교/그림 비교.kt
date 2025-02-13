fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val arr = Array(num) {
        Array(5) {
            CharArray(7)
        }
    }
    repeat(num) { index ->
        for(i in 0 until 5) {
            arr[index][i] = reader.readLine().toCharArray()
        }
    }

    var answer = Int.MAX_VALUE
    var ans: Pair<Int, Int> = 0 to 0

    for(i in 0 until num) {
        for(j in i + 1 until num) {
            val tmp = calcDif(arr[i], arr[j])
            if(answer > tmp){
                answer = tmp
                ans = Pair(i, j)
            }
        }
    }
    println("${ans.first + 1} ${ans.second + 1}")
}

fun calcDif(a: Array<CharArray>, b: Array<CharArray>): Int {
    var answer = 0
    for(i in 0 until 5){
        for(j in 0 until 7){
            if(a[i][j] != b[i][j]) answer ++
        }
    }
    return answer
}