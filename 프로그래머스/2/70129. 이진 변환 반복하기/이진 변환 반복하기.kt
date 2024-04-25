class Solution {
    fun solution(s: String): IntArray {
        if(s.length == 1)
            return intArrayOf(0, 0)
        var cntTransform = 1
        var cntZero = 0
        // 1의 개수
        var len = s.replace("0", "").length
        cntZero += s.length - len
        
        while(len > 1){
            cntTransform++
            var cntOne = 1
            
            while(len != 1){
                if(len % 2 == 1)
                    cntOne++
                else
                    cntZero++
                len /= 2
            }
            len = cntOne
        }
        
        var answer: IntArray = intArrayOf(cntTransform, cntZero)
        return answer
    }
}