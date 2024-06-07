class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        
        for(word in babbling){
            var idx = 0
            var isBabbling = true
            var prevChar = 'z'
            
            while(idx <= word.lastIndex) {
                var currentChar = word[idx]
                when(word[idx]){
                    'a' -> {
                        if(word.length - idx < 3){
                            isBabbling = false
                            break
                        }
                        if(word[idx + 1] == 'y' && word[idx + 2] == 'a'){
                            idx += 3
                        } else {
                            isBabbling = false
                            break
                        }
                    }
                    'y' -> {
                        if(word.length - idx < 2){
                            isBabbling = false
                            break
                        }
                        if(word[idx + 1] == 'e'){
                            idx += 2
                        } else {
                            isBabbling = false
                            break
                        }
                    }
                    'w' -> {
                        if(word.length - idx < 3){
                            isBabbling = false
                            break
                        }
                        if(word[idx + 1] == 'o' && word[idx + 2] == 'o'){
                            idx += 3
                        } else {
                            isBabbling = false
                            break
                        }
                    }
                    'm' -> {
                        if(word.length - idx < 2){
                            isBabbling = false
                            break
                        }
                        if(word[idx + 1] == 'a'){
                            idx += 2
                        } else {
                            isBabbling = false
                            break
                        }
                    }
                    else -> {
                        isBabbling = false
                        break
                    }
                }
                
                if(prevChar != currentChar){
                    prevChar = currentChar
                } else {
                    isBabbling = false
                    break
                }
            }
            if(isBabbling){
                answer++
                println(word)
            }
            
        }
        
        return answer
    }
}