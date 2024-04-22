import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()
    val map = Array(num) { br.readLine() }
    val verticalMap = Array(num) { CharArray(num) }

    for (i in 0 until num) {
        for (j in 0 until num) {
            verticalMap[j][i] = map[i][j]
        }
    }

    
    fun countSpaces(arr: Array<*>): Int {
        var count = 0
        arr.forEach {
            val str = if (it is String) it else String(it as CharArray)
            str.split("X").forEach { space ->
                if (space.length >= 2) count++
            }
        }
        return count
    }

    val hor = countSpaces(map) // 가로 방향 공간 세기
    val ver = countSpaces(verticalMap) // 세로 방향 공간 세기

    println("$hor $ver")
}