import java.util.*

class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        val defeatedE = PriorityQueue<Int>(compareByDescending<Int>{it})
        
        var answer: Int = 0
        var sum = 0
        var chance = k
        
        for(e in enemy){
            defeatedE.offer(e)
            sum += e
            
            if(sum > n){
                if(chance >= 1){
                    sum -= defeatedE.poll() 
                    chance--
                } else {
                    break
                }
            }
            answer++
        }
        
        return answer
    }
}