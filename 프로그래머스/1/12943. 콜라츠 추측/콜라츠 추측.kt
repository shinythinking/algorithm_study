class Solution {
    fun solution(num: Int): Int {
        var answer = 0
        var temp = num.toLong()
        while(temp != 1L){
            temp = when (temp % 2){
                0L -> temp / 2
                else -> temp *3 + 1
            }
            answer ++
        }
        
        if(answer > 500)
            answer = -1
        
        return answer
    }
}