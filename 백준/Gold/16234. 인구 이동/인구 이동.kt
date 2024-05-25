import java.util.*
import java.io.*

lateinit var parent: IntArray
fun union(x: Int, y: Int): Boolean {
    val x = find(x)
    val y = find(y)
    if(x == y) return false
    else parent[x] = y
    return true
}

fun find(x: Int): Int{
    if(parent[x] == x) return x
    return find(parent[x])
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var answer = 0
    val(size, left, right) = readLine().split(' ').map{ it.toInt() }

    parent = IntArray(size * size){ it }

    val matrix = Array(size) { IntArray(size) }
    for(i in 0 until size)
        matrix[i] = readLine().split(' ').map{ it.toInt() }.toIntArray()

    val dRow = intArrayOf(0, 1)
    val dCol = intArrayOf(1, 0)


    while(true){
        val safe = size - 1
        // 1. 연결된 것들이 범위 안인지 -> Union-Find
        for (i in 0 until safe) {
            for (j in 0 until safe) {
                for (k in 0..1) {
                    val newRow = i + dRow[k]
                    val newCol = j + dCol[k]
                    if (Math.abs(matrix[i][j] - matrix[newRow][newCol]) in left..right) {
                        union(i * size + j, newRow * size + newCol)
                    }
                }
            }
        }
        for(i in 0 until safe) {
            if(Math.abs(matrix[safe][i] - matrix[safe][i + 1]) in left..right) {
                union(safe * size + i, safe * size + i + 1)
            }
            if(Math.abs(matrix[i][safe] - matrix[i + 1][safe]) in left..right){
                union(i * size + safe, (i + 1) * size + safe)
            }
        }


        val groups = parent
            .mapIndexed{ index, value -> find(value) to index}
            .groupBy{ it.first}
            .values
            .map{ it.map{ pair -> pair.second } }

        if(groups.size == parent.size)
            break
        else {
            for(group in groups){
                if(group.size > 1) {
                    var sum = 0
                    for (p in group) {
                        sum += matrix[p / size][p % size]
                    }
                    for(p in group){
                        matrix[p / size][p % size] = sum / group.size
                    }
                }
            }
        }
        answer++
        parent = IntArray(size * size){ it }

    }
    print(answer)
}