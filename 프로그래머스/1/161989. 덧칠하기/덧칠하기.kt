import java.util.*

class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        val sections = PriorityQueue<Int>(section.size)
        var answer: Int = 0
        for(d in section)
            sections.offer(d)
        
        while(sections.isNotEmpty()){
            val start = sections.poll()
            answer++
            
            while((sections.peek() ?: break) <= start + m - 1){
                sections.poll()
            }
        }
        return answer
    }
}