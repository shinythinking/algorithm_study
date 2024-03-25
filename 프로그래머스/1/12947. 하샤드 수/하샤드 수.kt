class Solution {
    fun solution(x: Int): Boolean {
        
        var divisor = 0
        var num = x
        while(num != 0){
            divisor += num % 10
            num /= 10
        }
        return (x % divisor == 0)
    }
}