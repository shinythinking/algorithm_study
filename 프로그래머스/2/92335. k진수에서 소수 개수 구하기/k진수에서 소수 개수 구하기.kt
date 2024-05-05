import java.math.*
class Solution {
    fun solution(n: Int, k: Int): Int {
        /*val isComposite = BooleanArray(1_000_001)
        isComposite[1] = true
        for(i in 2..15000){
            var num = i
            if(!isComposite[i]){
                while(i * num <= Int.MAX_VALUE){
                    isComposite[i * num] = true
                    num++
                }
            }
        }*/
        
        val str = n.toString(k)
        val strArr = str.split('0').filter{ it.isNotBlank() }.map{ BigInteger(it) }
        
        var answer = 0
        for(d in strArr){
            if(d.isProbablePrime(10))
                answer++
        }
        
        return answer
    }
}