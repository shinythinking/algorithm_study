fun main() = with(System.`in`.bufferedReader()){
    var (left, right) = readLine().split(' ').map{ it.toInt() }
    var three = 1
    val max = Math.max(left, right)
    if(max == 0){
        print(1)
        return
    }

    while(max >= three)
        three *= 3
    three /= 3

    while(three > 1){
        if(left < right){
            right -= three
        } else {
            left -= three
        } 
        three /= 3
    }
    if(left == 1 && right == 0 || left == 0 && right == 1){
        print(1)
    } else {
        print(0)
    }
}