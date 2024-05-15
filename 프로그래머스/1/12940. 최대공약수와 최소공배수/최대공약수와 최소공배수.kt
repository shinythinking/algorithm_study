class Solution {
    fun solution(n: Int, m: Int): IntArray {
        val gcd = findGCD(n, m)
        
        return intArrayOf(gcd, n * m / gcd)
    }
    fun findGCD(left: Int, right: Int): Int{
        var big = right
        var small = left % right
        while(small != 0){
            val remainder = big % small
            big = small
            small = remainder
        }
        return big
    }
}