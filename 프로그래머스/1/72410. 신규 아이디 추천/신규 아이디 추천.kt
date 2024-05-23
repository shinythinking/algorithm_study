class Solution {
    fun solution(new_id: String): String {
        var regexForSpecial = """[~!@#$%^&*()=+\[\{\]\}:?,<>/]""".toRegex()
        var regexForDot = "[.]{2,}".toRegex()
        var edittedId = new_id.lowercase()
            .replace(regexForSpecial, "")
            .replace(regexForDot, ".")
            .trim('.')
                   
        println(edittedId)
        if(edittedId.length in 3..15)
            return edittedId
        
        if(edittedId.length == 0)
            edittedId = "aaa"
        else if(edittedId.length > 15){
            edittedId = edittedId.substring(0..14)
            edittedId = edittedId.trim('.')
        }
        else if(edittedId.length == 2)
            edittedId += edittedId[1]
        else if(edittedId.length == 1){
            edittedId += edittedId[0]
            edittedId += edittedId[0]
        }
        
        print(edittedId)
        
        
        
        return edittedId
    }
}