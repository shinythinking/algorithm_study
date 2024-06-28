fun main() = with(System.`in`.bufferedReader()){
    var num = readLine().toInt()
    val frequency = mutableMapOf<Long, Int>()
    
    while(num --> 0){
        val input = readLine().toLong()
        frequency[input] = frequency.getOrDefault(input, 0) + 1
    }
    
    val freqEntries = frequency.entries
    val comp = compareByDescending<MutableMap.MutableEntry<Long, Int>>{ it.value }.thenBy{ it.key }
    val sortedByValue = freqEntries.sortedWith(comp)
    print(sortedByValue.first().key)
}