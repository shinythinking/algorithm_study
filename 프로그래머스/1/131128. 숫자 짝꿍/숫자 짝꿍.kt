class Solution {
    fun solution(X: String, Y: String): String {
        var answer = ""
        
        val numArrX = IntArray(10)
        val numArrY = IntArray(10)
        
        for(i in X.indices)
            numArrX[ X[i] - '0'] += 1
        for(i in Y.indices)
            numArrY[ Y[i] - '0'] += 1
        
        for(i in 9 downTo 0){
            val min = Math.min(numArrX[i], numArrY[i])
            answer += "$i".repeat(min)
        }
        
        return if(answer.length == 0)
            "-1" 
        else if(answer[0] == '0')
            "0"
        else
            answer
    }
}