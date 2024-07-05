fun main() = with(System.`in`.bufferedReader()){
    val setOfPoint = mutableSetOf<Pair<Int, Int>>()
    repeat(4){
        val(x1, y1, x2, y2) = readLine().split(' ').map{ it.toInt() }
        for(i in x1 until x2){
            for(j in y1 until y2){
                setOfPoint.add(Pair(i, j))
            }
        }
    }
    print(setOfPoint.size)
}