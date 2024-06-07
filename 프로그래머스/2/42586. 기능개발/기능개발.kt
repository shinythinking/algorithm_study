class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        var days = 0
        var idx = 0
        var sum = 0
        while(sum < progresses.size) {
            days += Math.ceil((100 - progresses[idx]).toDouble() / speeds[idx].toDouble()).toInt()
            var cnt = 1
            for(j in idx + 1..progresses.lastIndex){
                progresses[j] += speeds[j] * days
                if(progresses[j] >= 100)
                    cnt++
                else{
                    idx = j
                    break
                }
            }
            sum += cnt
            answer += cnt
        }
        return answer
    }
}