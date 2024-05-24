import java.util.*
import java.io.*

const val mod = 1_000

fun powByDQ(matrix: Array<IntArray>, exponent: Long): Array<IntArray> {
    if(exponent == 1L)
        return matrix

    val temp = powByDQ(matrix, exponent / 2)

    if(exponent % 2 == 0L)
        return getMatrixMulti(temp, temp)
    else
        return getMatrixMulti(getMatrixMulti(temp, temp), matrix)
}

fun getMatrixMulti(matrix1: Array<IntArray>, matrix2: Array<IntArray>): Array<IntArray> {
    val result = Array(matrix1.size) { IntArray(matrix2[0].size) }

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
    val(size, exponent) = readLine().split(" ").map { it.toLong() }
    val answer = StringBuilder()

    val matrix = Array(size.toInt()){ IntArray(size.toInt()) }
    for(i in 0 until size.toInt()){
        matrix[i] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }

    val result = powByDQ(matrix, exponent)
    for(i in result){
        for(j in i){
            answer.append(j % mod).append(" ")
        }
        answer.append('\n')
    }
    print(answer)
}