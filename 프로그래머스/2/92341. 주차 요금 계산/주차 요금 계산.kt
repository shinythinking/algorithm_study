import java.util.*

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val tmAns = TreeMap<String, Int>()
        val inout = mutableMapOf<String, Int>()
        
        for(str in records){
            val record = str.split(" ")
            val times = record[0].split(':').map{ it.toInt() }
            val time = times[0] * 60 + times[1]
            
            if(record[2] == "IN"){
                inout[record[1]] = time
            } else {
                val useTime = time - inout.getOrDefault(record[1],0)
                inout.remove(record[1])
                
                tmAns[record[1]] = tmAns.getOrDefault(record[1], 0) + useTime
            } 
        }
        
        for(i in inout.values){
            println(i)
        }
        
        val time = 23 * 60 + 59
        for(entry in inout.entries){
            tmAns[entry.key] = tmAns.getOrDefault(entry.key, 0) + time - entry.value
        }
        
        for(i in tmAns.values){
            println(i)
        }
        
        for(entry in tmAns.entries){
            if(fees[0] >= entry.value){
                tmAns[entry.key] = fees[1]
            } else {
                var exceding = entry.value - fees[0]
                println("초과 ${(fees[2] - exceding % fees[2])}")
                var added = 0
                if(exceding % fees[2] != 0)
                    added = 1
                tmAns[entry.key] = (exceding / fees[2] + added) * fees[3] + fees[1]
            }
        }
        
        
        return tmAns.values.toIntArray()
    }
}