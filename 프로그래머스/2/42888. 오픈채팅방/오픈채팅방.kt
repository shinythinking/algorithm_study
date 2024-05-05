import java.util.*

class Solution {
    fun solution(record: Array<String>): Array<String> {
        val user = mutableMapOf<String, String>()
        for(statement in record){
            val words = statement.split(" ")
            if(words[0][0] == 'L')
                continue
            user[words[1]] = words[2]
        }
        
        var answer = arrayOf<String>()
        for(statement in record){
            val words = statement.split(" ")
            var str = ""
            if(words[0][0] == 'E')
                str = "들어왔습니다."
            else if(words[0][0] == 'L')
                str = "나갔습니다."
            else
                continue
            answer += "${user[words[1]]!!}님이 ${str}"
        }
        return answer
    }
}