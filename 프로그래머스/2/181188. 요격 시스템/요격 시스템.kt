import java.util.*

class Solution {
    fun solution(targets: Array<IntArray>): Int {
        val comp = compareBy<IntArray> ( { it[0] }, { it[1] })
        val compForT = compareByDescending<IntArray> { it[0] }
        targets.sortWith(comp)
        
        val launchRange = PriorityQueue<IntArray>(compForT)
        
        launchRange.offer(targets[0])
        
        for(i in 1 .. targets.lastIndex){
            val targetRange = launchRange.peek()
            if(targets[i][0] in targetRange[0] until targetRange[1]){
                val polled = launchRange.poll()
                if(polled[0] < targets[i][0])
                    polled[0] = targets[i][0]
                if(polled[1] > targets[i][1])
                    polled[1] = targets[i][1]
                launchRange.offer(polled)
            } else {
                launchRange.offer(targets[i])
            }
            
        }
        
        return launchRange.size
    }
}