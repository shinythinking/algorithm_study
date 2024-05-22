import java.util.*

class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        val rows = mutableListOf<Int>()
        val cols = mutableListOf<Int>()
        for((row, line) in wallpaper.withIndex()){
            for((col, files) in line.withIndex()){
                if(files == '#'){
                    rows.add(row)
                    cols.add(col)
                }
            }
        }
        rows.sort()
        cols.sort()
        
        return intArrayOf(rows[0],cols[0], rows.last() + 1, cols.last() + 1)
    }
}