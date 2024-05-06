class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer = 0
        var sum1 = queue1.sum().toLong()
        var sum2 = queue2.sum().toLong()
        if((sum1 + sum2) % 2 != 0L)
            return -1
        val ans = (sum1 + sum2) / 2
        
        val totalArray = queue1 + queue2 + queue1
        var head = 0
        var tail = queue1.lastIndex
        
        while(head <= tail){
            
            if(sum1 == ans)
                return answer
            
            else if(sum1 > ans){
                
                sum1 -= totalArray[head]
                head++
            } else {
                
                tail++
                if(tail >= totalArray.size)
                    break
                sum1 += totalArray[tail]
            }
            answer++
        }
        return -1
    }
}