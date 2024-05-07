class Solution {
    fun solution(arr: IntArray): Int {
        var lcmV = arr[0]
        for(i in 1..arr.lastIndex){
            lcmV = lcm(arr[i], lcmV)
        }
        
        return lcmV
    }
    fun lcm(a: Int, b: Int): Int{
        var left = a
        var right = b
        while(right != 0){
            val r = left % right
            left = right
            right = r
        }
        
        return (a / left) * b
    }
}