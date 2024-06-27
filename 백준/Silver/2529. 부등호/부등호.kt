fun main() = with(System.`in`.bufferedReader()){
    val num = readLine().toInt()
    val inequality = readLine().split(' ')

    val big = IntArray(num + 1){ 9 - it }
    val small = IntArray(num + 1){ it }

    var prev = inequality[0]
    var cnt = 1
    val listOfFreq = mutableListOf<Int>()
    for(i in 1 until num){
        if(prev == inequality[i]){
            cnt++
        } else {
            listOfFreq.add(cnt)
            cnt = 1
            prev = inequality[i]
        }
    }
    listOfFreq.add(cnt)
    var idx = 0
    for(freq in listOfFreq){
        if(inequality[idx] == ">"){
            var start = idx
            var end = start + freq
            idx = end
            while(start < end){
                val temp = small[start]
                small[start] = small[end]
                small[end] = temp
                start++
                end--
            }
        } else {
            var start = idx
            var end = start + freq
            idx = end
            while(start < end){
                val temp = big[start]
                big[start] = big[end]
                big[end] = temp
                start++
                end--
            }
        }
    }

    print("${big.joinToString("")}\n${small.joinToString("")}")
}