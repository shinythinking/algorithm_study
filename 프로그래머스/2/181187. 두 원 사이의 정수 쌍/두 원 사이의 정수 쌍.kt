class Solution {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0
        val r1Square = r1.toDouble() * r1.toDouble()
        val r2Square = r2.toDouble() * r2.toDouble()
        
        for(i in 0 .. r2){
            val iSquare = i.toDouble() * i.toDouble()
            answer += (Math.floor(Math.sqrt(r2Square - iSquare)).toLong() - Math.ceil(Math.sqrt(r1Square - iSquare)).toLong()) + 1L
        }
        return (answer - (r2 - r1 + 1)) * 4
    }
}