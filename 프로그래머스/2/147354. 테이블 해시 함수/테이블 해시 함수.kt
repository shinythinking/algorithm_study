class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        val comp = compareBy<IntArray>{ it[col - 1] }.thenByDescending{ it[0] }
        data.sortWith(comp)

        var previous = 0
        for(i in row_begin .. row_end){
            var sum = 0
            for(d in data[i - 1]){
                sum += d % i
            }
            previous = previous xor sum
        }
        
        return previous
    }
}