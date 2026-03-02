class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        
        var ans = 0
        fun dfs(depth: Int, sum: Int) {
            if(depth == numbers.size) {
                if(sum == target) ans ++
                return 
            }
            dfs(depth + 1, sum + numbers[depth])
            dfs(depth + 1, sum - numbers[depth])
        }
        dfs(0, 0)
        
        return ans
    }
}