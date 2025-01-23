fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val current = reader.readLine().trim().split(" ").map { it.toInt() }
    val target = reader.readLine().trim().split(" ").map { it.toInt() }
    val dif = Array(num) { i ->
        target[i] - current[i]
    }

    var answer = 0
    var startIdx = 0

    while (true) {
        while (dif[startIdx] == 0) {
            startIdx++
            if(startIdx == num){
                println(answer)
                return
            }
        }
        var endIdx = startIdx

        val isPositive = dif[startIdx] > 0

        for (i in startIdx + 1 until num) {
            if (dif[i] == 0) break

            endIdx = if (isPositive) {
                if (dif[i] > 0)
                    i
                else
                    break
            } else {
                if (dif[i] < 0)
                    i
                else
                    break
            }
        }
        val absMax = if(isPositive){
            dif.slice(startIdx..endIdx).min()
        } else {
            dif.slice(startIdx..endIdx).max()
        }

        for(i in startIdx .. endIdx) {
            dif[i] -= absMax
        }
        answer += Math.abs(absMax)
    }
}