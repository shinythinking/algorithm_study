class Solution {
    data class Pos(val x: Long, val y: Long)
    
    fun solution(line: Array<IntArray>): Array<String> {
        val intersections = mutableListOf<Pos>()
        var maxX = Long.MIN_VALUE
        var maxY = Long.MIN_VALUE
        var minX = Long.MAX_VALUE
        var minY = Long.MAX_VALUE
        
        val lines = Array(line.size){it ->
            line[it].map{it.toLong()}
        }
        
        for(i in lines.indices){
            for(j in i + 1..lines.lastIndex){
                val a = lines[i][0]
                val b = lines[i][1]
                val c = lines[i][2]
                val d = lines[j][0]
                val e = lines[j][1]
                val f = lines[j][2]
                val divisor = e * a - b * d
                if(divisor == 0L)
                    continue
                
                val dividend = b * f  - c * e
                if(dividend % divisor != 0L)
                    continue
                
                val x = dividend / divisor
                
                if((a * f - c * d) % divisor != 0L)
                    continue
                
                val y = (a * f - c * d) / divisor                    
                intersections.add(Pos(x, y))
                maxX = Math.max(maxX, x)
                maxY = Math.max(maxY, y)
                minX = Math.min(minX, x)
                minY = Math.min(minY, y)    
                
            }
        }        
        
        val answer = Array((maxY - minY + 1L).toInt()) { CharArray((maxX - minX + 1L).toInt() ){ '.' } }
        for(intersection in intersections){
            answer[(intersection.y - minY).toInt()][(intersection.x - minX).toInt()] = '*'
        }
        
        var realAnswer = Array(answer.size){ i ->
            answer[i].joinToString("")
        }
        
        return realAnswer
        
    }
}