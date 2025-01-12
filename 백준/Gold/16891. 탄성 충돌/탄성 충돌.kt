fun main() {
    val reader = System.`in`.bufferedReader()
    val num = reader.readLine().toInt()
    val weight = num * num
    var answer = 0
    var pA = 0.0
    var pB = -1.0
    while(true) {
       var vA = ((1 - weight) * pA + (2 * weight) * pB) / (1 + weight).toDouble()
       val vB = (2 * pA - ((1 - weight) * pB)) / (1 + weight).toDouble()
       if(vA >= 0) {
           println(answer + 1)
           return
       } else {
           vA *= -1
           if(vB > 0){
               if(vB >= vA) {
                   println(answer + 2)
                   return
               }
               else answer += 2
           } else{
               answer += 2
           }
       }
        pA = vA
        pB = vB
    }
}