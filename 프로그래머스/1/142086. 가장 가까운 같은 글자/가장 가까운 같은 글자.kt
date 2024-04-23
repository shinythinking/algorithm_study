class Solution {
    fun solution(s: String): IntArray {
        var intArr = IntArray(26) { -1 }
        
        var answer: IntArray = IntArray(s.length)
        for((i, ch) in s.withIndex()){
            val target = ch - 'a'
            if(intArr[target] == -1){
                answer[i] = -1
            } else {
                answer[i] = (i - intArr[target])
            }
            intArr[target] = i
        }
        return answer
    }
}