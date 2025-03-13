fun main() {
    val reader = System.`in`.bufferedReader()
    val str = reader.readLine()
    val query = reader.readLine().toInt()
    val arr = Array(26) {
        IntArray(str.length){0}
    }
    arr[str[0] - 'a'][0] = 1
    for(i in 1 until str.length) {
        for(j in 0..25) {
            arr[j][i] = arr[j][i - 1]
        }
        arr[str[i] - 'a'][i] += 1
    }

    val answer = buildString {
        repeat(query) {
            val input = reader.readLine().split(" ")
            val target = input[0].first() - 'a'
            val from = input[1].toInt() - 1
            val to = input[2].toInt()

            appendLine(arr[target][to] - (arr[target].getOrNull(from) ?: 0) )
        }
    }
    println(answer)
}