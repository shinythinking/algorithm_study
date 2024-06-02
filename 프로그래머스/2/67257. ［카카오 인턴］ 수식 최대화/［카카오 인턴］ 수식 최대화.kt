import java.util.*

class Solution {
    fun solution(expression: String): Long {
        var answer: Long = 0
        val orgNumList = LinkedList<Long>()
        val orgOpList = LinkedList<Char>()
        
        var temp = ""
        for(ch in expression){
            if(ch in '0'..'9'){
                temp += ch
            } else {
                orgNumList.add(temp.toLong())
                orgOpList.add(ch)
                temp = ""
            }
        }
        orgNumList.add(temp.toLong())
        
        val setOfOp = orgOpList.toSet()
        
        getOpComb(BooleanArray(setOfOp.size), "", setOfOp.toList(), 0)
        
        
        
        for(comb in combOp){
            
            println(comb)
            val numList = orgNumList.toMutableList()
            val opList = orgOpList.toMutableList()
            
            for(op in comb){
                var i = -1
                for(idx in 0..opList.lastIndex){
                    i++
                    if(opList[i] == op){
                        opList.removeAt(i)
                        when (op) {
                            '+' -> numList[i] += numList.removeAt(i + 1)
                            '*' -> numList[i] *= numList.removeAt(i + 1)
                            else -> numList[i] -= numList.removeAt(i + 1)
                        }
                        i--
                    }
                }
            }
            println(numList[0])
            answer = Math.max(answer, Math.abs(numList[0]))
        }
        
       
        return answer
    }
    
    val combOp = mutableListOf<String>()
    fun getOpComb (visited: BooleanArray, comb: String, opList: List<Char>, cnt: Int){
        if(comb.length == opList.size){
            combOp.add(comb)
        }
        
        for (i in 0..opList.lastIndex){
            if(visited[i])
                continue
            visited[i] = true
            getOpComb(visited, comb + opList[i], opList, cnt + 1)
            visited[i] = false
        }
    }
}