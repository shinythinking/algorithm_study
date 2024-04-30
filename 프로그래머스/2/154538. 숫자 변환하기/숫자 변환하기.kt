import java.util.*


class Solution {

    data class Data(val num: Int, val cnt: Int)
    
    fun solution(x: Int, y: Int, n: Int): Int {
        if(x == y)
            return 0
        val queue = LinkedList<Data>()
        val visited = BooleanArray(y + 1)
        queue.offer(Data(y, 0))
        
        while(queue.isNotEmpty()){
            var polled = queue.poll()
            visited[polled.num] = true
            for(i in 3 downTo 2){
                if(polled.num % i != 0)
                    continue
                val newN = polled.num / i
                if(newN == x)
                    return polled.cnt + 1
                if(!visited[newN]){
                    visited[newN] = true
                    queue.offer(Data(newN, polled.cnt + 1))
                }
            }
            val newN = polled.num - n
            if(newN < x || visited[newN])
                continue
            if(newN == x)
                return polled.cnt + 1
            visited[newN] = true
            queue.offer(Data(newN, polled.cnt + 1))
            
        }
        return -1
    }
}