import java.util.*
import java.io.*

val diff = mutableListOf<IntArray>()

fun getDiff(combination: IntArray, depth: Int, idx: Int){
    if(combination.size == depth){
        diff.add(combination)
        return
    }

    for(i in idx until depth * 2){
        getDiff(combination + i, depth, i+ 1)
    }

}

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine().toInt()
    val players = Array(num){
        readLine().split(' ').map{ it.toInt() }.toMutableList()
    }

    for(i in players.indices){
        for(j in i until num){
            players[i][j] += players[j][i]
        }
    }

    getDiff( intArrayOf(), num / 2, 0)

    val sums = IntArray(diff.size)
    for((k, comb) in diff.withIndex()){
        for(i in comb.indices){
            for(j in i + 1..comb.lastIndex){
                sums[k] += players[comb[i]][comb[j]]
            }
        }
    }
    var min = Int.MAX_VALUE

    for(i in 0..sums.lastIndex / 2) {
        sums[i] = Math.abs(sums[i] - sums[sums.lastIndex - i])
        min = Math.min(min, sums[i])
    }

    println(min)
}