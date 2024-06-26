fun main() = with(System.`in`.bufferedReader()){
    var testcase = readLine().toInt()
    val answer = StringBuilder()
    
    while(testcase --> 0){
        val input = readLine()
        
        val left = ArrayDeque<Char>()
        val right = ArrayDeque<Char>()
        
        for(ch in input){
            when(ch){
                '<' -> right.addLast(left.removeLastOrNull() ?: continue)
                '>' -> left.addLast(right.removeLastOrNull() ?: continue)
                '-' -> left.removeLastOrNull() ?: continue
                else -> left.addLast(ch)
            }
        }
        while(right.isNotEmpty())
            left.addLast(right.removeLast())
        
        answer.append(left.joinToString("")).append('\n')
    }
    print(answer)
}