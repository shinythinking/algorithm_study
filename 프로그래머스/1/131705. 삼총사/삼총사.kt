class Solution {
    var answer: Int = 0
    fun solution(number: IntArray): Int {
        combination(number, 0, 0, 0)
        return answer
    }
    fun combination(number: IntArray, depth: Int, sum: Int, idx: Int) {
        if(depth == 3){
            if(sum == 0)
                answer++
            return 
        }
        
        for(i in idx..number.lastIndex){
            combination(number, depth + 1, sum + number[i], i + 1)
        }
        
        
    }
}