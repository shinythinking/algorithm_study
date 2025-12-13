fun main() {
    var input = readln()
    var idx = 1
    while(!input.contains("-")) {
        val stack = ArrayDeque<Char>()
        var ans = 0
        for(c in input) {
            if(c == '{') stack.addLast(c)
            else if(c == '}') {
                val tmp = stack.lastOrNull()
                if(tmp == null) {
                    ans++
                    stack.addLast('{')
                } else if(tmp == '{') {
                    stack.removeLast()
                } else {
                    ans++
                    stack.removeLast()
                }
            }
        }
        if(stack.isNotEmpty()) {
            ans += (stack.size / 2)
        }
        println("$idx. $ans")
        idx++
        input = readln()
    }
}