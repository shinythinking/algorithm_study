fun main() {
    val reader = System.`in`.bufferedReader()
    var num = reader.readLine().toInt()
    var temp = 0
    var temp1 = 0
    while (num > 0) {
        temp += 5
        temp1 = temp
        while(temp1 % 5 == 0){
            temp1 /= 5
            num -= 1
        }
    }
    num = if (num < 0) -1 else temp
    println(num)
}