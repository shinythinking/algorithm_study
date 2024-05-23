import java.util.*

class Solution {

    data class Unit(var row: Int, var col: Int, val cnt: Int)
    
    fun solution(maps: Array<String>): Int {
        var answer: Int = 0
        
        val start = Unit(0, 0, 0)
        val lever = Unit(0, 0, 0)
        
        for((i, row) in maps.withIndex()){
            val indexS = row.indexOf('S')
            val indexL = row.indexOf('L')
            if(indexS != -1){
                start.row = i
                start.col = indexS    
            }
            if(indexL != -1){
                lever.row = i
                lever.col = indexL
            }
        }
        val cntStartToLever = bfs(maps, start, 'L')
        if(cntStartToLever == -1)
            return -1
        
        val cntLeverToEnd = bfs(maps, lever, 'E')
        if(cntLeverToEnd == -1)
            return -1
        
        return cntStartToLever + cntLeverToEnd
    }
    
    fun bfs(maps: Array<String>, start: Unit, target: Char): Int{
        var count = 0
        val visited = Array(maps.size){ BooleanArray(maps[0].length) }
        val queue = LinkedList<Unit>()
        queue.offer(start)
        visited[start.row][start.col] = true
        
        val dRow = intArrayOf(1, -1, 0, 0)
        val dCol = intArrayOf(0, 0, 1, -1)
        
        while(queue.isNotEmpty()){
            val polled = queue.poll()
            for(i in 0..3){
                val newRow = polled.row + dRow[i]
                val newCol = polled.col + dCol[i]
                
                if(newRow < 0 || newCol < 0 || newRow >= maps.size || newCol >= maps[0].length)
                    continue
                if(visited[newRow][newCol] || maps[newRow][newCol] == 'X')
                    continue
                if(maps[newRow][newCol] == target)
                    return polled.cnt + 1
                
                visited[newRow][newCol] = true
                queue.offer(Unit(newRow, newCol, polled.cnt + 1))
                println(newRow)
                
            }
        }
        return -1
    }
}