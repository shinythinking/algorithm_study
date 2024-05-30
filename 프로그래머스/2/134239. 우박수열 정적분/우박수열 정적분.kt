class Solution {
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        var answer: DoubleArray = doubleArrayOf()
        var sizes = doubleArrayOf()
        var initial = k
        var cnt = 0
        
        while(initial != 1){
            cnt++
            if(initial % 2 == 0){
                sizes += initial * 0.75
                initial /= 2
            } else {
                sizes += initial * 2  + 0.5
                initial = initial * 3 + 1
            }
        }
        
        for(range in ranges){
            val left = range[0]
            val right = cnt + range[1]
            
            if(left > right || right > cnt){
                answer += -1.0
            } else if (left == right){
                answer += 0.0
            } else {
                var sum = 0.0
                for(i in left until right){
                    sum += sizes[i]
                }
                answer += sum
            }
        }
        
        return answer
    }
}