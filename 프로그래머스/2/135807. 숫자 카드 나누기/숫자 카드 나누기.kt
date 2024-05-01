class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var gcdA = arrayA[0]
        var gcdB = arrayB[0]
        
        for(a in arrayA){
            gcdA = gcd(a, gcdA)
        }
        for(b in arrayB){
            gcdB = gcd(b, gcdB)
        }
        var flagA = true
        var flagB = true
        for(a in arrayA){
            if(a % gcdB == 0)
                flagB = false
        }
        
        for(b in arrayB){
            if(b % gcdA == 0)
                flagA = false
        }
        
        return if(flagA){
            if(flagB){
                if(gcdA > gcdB) gcdA else gcdB 
            }else{
                 gcdA
            }
        } else {
            if(flagB)
                gcdB
            else
                0
        }
    }
    fun gcd(a: Int, b: Int): Int{
        var big = a
        var small = b
        var remainder = 0
        while(small != 0){
            remainder = big % small
            big = small
            small = remainder
        }
        return big
    }
}