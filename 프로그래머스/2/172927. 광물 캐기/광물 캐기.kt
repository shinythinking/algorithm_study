import java.util.*

class Solution {
    data class Mineral(
        val dia: Int,
        val iron: Int,
        val stone: Int
    )
    
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        val maxStone = picks.sum()
        val chunkedMArr = minerals.toList().chunked(5).take(maxStone)
        for(arr in chunkedMArr){
            for(i in arr){
                print("$i ")
            }
            println()
        }
        val pqForMineral = PriorityQueue<Mineral>(compareByDescending<Mineral> {it.dia}.thenByDescending {it.iron}.thenByDescending {it.stone} )
        
        for(arr in chunkedMArr){
            var diaNum = 0
            var ironNum = 0
            var stoneNum = 0
            for(str in arr){
                when(str[0]){
                    'd' -> diaNum++
                    'i' -> ironNum++
                    else -> stoneNum++
                }
            }
            pqForMineral.offer(Mineral(diaNum, ironNum, stoneNum))
        }
        
        var answer: Int = 0
        for((i, pick) in picks.withIndex()){
            for(j in 1..pick){
                val frontM = pqForMineral.poll() ?: break
                answer += when(i){
                    0 -> frontM.dia + frontM.iron + frontM.stone
                    1 -> frontM.dia * 5 + frontM.iron + frontM.stone
                    else -> frontM.dia * 25 + frontM.iron * 5 + frontM.stone
                }
                
            }
        }
        return answer
    }
}