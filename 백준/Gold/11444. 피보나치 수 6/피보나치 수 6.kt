import java.util.*
import java.io.*

const val mod = 1_000_000_007L

fun powByDQ(matrix: Array<LongArray>, exponent: Long): Array<LongArray> {
    if(exponent == 1L)
        return matrix

    val temp = powByDQ(matrix, exponent / 2)

    if(exponent % 2 == 0L)
        return getMatrixMulti(temp, temp)
    else
        return getMatrixMulti(getMatrixMulti(temp, temp), matrix)
}

fun getMatrixMulti(matrix1: Array<LongArray>, matrix2: Array<LongArray>): Array<LongArray> {
    val result = Array(matrix1.size) { LongArray(matrix2[0].size) }

    for(i in matrix1.indices){
        for(j in matrix2[0].indices){
            for(k in matrix1[0].indices){
                result[i][j] += matrix1[i][k] * matrix2[k][j]
                result[i][j] %= mod
            }
        }
    }
    return result
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val exponent = readLine().toLong()
    val answer = StringBuilder()

    val matrix = arrayOf(
        longArrayOf(1L, 1L),
        longArrayOf(1L, 0L)
    )

    val result = powByDQ(matrix, exponent)

    print(result[0][1])
}