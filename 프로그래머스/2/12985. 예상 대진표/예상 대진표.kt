class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
 
        var ap = a
        var bp = b
        while(ap != bp){
            answer ++
            if(ap % 2 != 0)
                ap++
            if(bp % 2 != 0)
                bp++
            ap /= 2
            bp /= 2
        }

        return answer
    }
}