class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var honorRanking = mutableListOf<Int>()
        var min  = score[0]
        for(i in 0 until k){
            if(i >= score.size)
                return answer
            min = Math.min(min, score[i])
            honorRanking += score[i]
            answer += min
        }
        
        for(i in k .. score.lastIndex){
            if(score[i] <= min){
                answer += min
            } else {
                honorRanking += score[i]
                honorRanking = honorRanking.sortedDescending().toMutableList()
                min = honorRanking[k - 1]
                answer += min
                
            }
        }
        return answer
    }
}