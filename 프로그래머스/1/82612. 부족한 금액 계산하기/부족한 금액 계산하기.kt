class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var answer: Long = -1
        var n = 0L
        
        if(count % 2 == 0){
            n = (1 + count.toLong()) * (count.toLong() / 2)
        } else {
            n = ((1 + count.toLong()) / 2) * count.toLong() 
        }
        answer = (n * price) - money.toLong()
        return if(answer < 0) 0L else answer
    }
}