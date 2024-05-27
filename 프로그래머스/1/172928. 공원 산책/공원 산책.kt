class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var curRow = 0
        var curCol = 0
        for((i, rowP) in park.withIndex()){
            val colP = rowP.indexOf('S')
            if(colP != -1){
                curRow = i
                curCol = colP
                break
            }
        }

        val dRow = intArrayOf(-1, 1, 0, 0)
        val dCol = intArrayOf(0, 0, -1, 1)
        val borderRow = park.size
        val borderCol = park[0].length
        
        for(route in routes){
            val(dire, dist) = route.split(' ')
            val direction = when(dire) {
                "N" -> 0 
                "S" -> 1
                "W" -> 2
                else -> 3
            }
            var distance = dist.toInt()
            
            var newRow = curRow
            var newCol = curCol
            if(direction in 0..1){
                while(distance --> 0){
                    newRow += dRow[direction]
                    if(newRow !in 0 until borderRow || park[newRow][newCol] == 'X'){
                        newRow = curRow
                        break
                    }
                }
            } else {
                while(distance --> 0){
                    newCol += dCol[direction]
                    if(newCol !in 0 until borderCol || park[newRow][newCol] == 'X'){
                        newCol = curCol
                        break
                    }
                }
            }
            curRow = newRow
            curCol = newCol
        }

        var answer: IntArray = intArrayOf(curRow, curCol)
        return answer
    }
}