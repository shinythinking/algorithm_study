import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {


    val num = readLine()!!.toInt()
    val tree = readLine()!!.split(" ").map { it.toInt() }.sortedDescending().mapIndexed { i, n -> i + 2 + n }.max()
    print(tree)


    /*var(N, K) = readLine()!!.split(' ').map { it.toInt() }

    if(N <= K){
        print((K - N))
        return
    }

    val powerTwo = ArrayList<Int>()
    var twoPower = 1
    while(twoPower <= N) {
        powerTwo.add(twoPower)
        twoPower *= 2
    }


    while(K > 1 && N > 0){
        K--
        N -= powerTwo.removeLast()

    }
    if(N <= 0){
        print(0)
    }else{
        val lastOne = if(powerTwo.last() >= N) powerTwo[powerTwo.lastIndex] else powerTwo[powerTwo.lastIndex] * 2
        print(lastOne - N)
    }*/

/*
    //IntArray == int[]
    //primitive 타입의 배열로 매핑
    //사이즈만 넘겨줘도 괜찮다.
    //toIntArray() 의 반환값
    val intArray = IntArray(5)
    var intArrof = intArrayOf()
    intArrof += 8
    println(intArray.javaClass)

    //Array<Int> == Integer[]
    //초기화를 해서 넘겨줘야 함.
    //toTypedArray()의 반환값
    val array1 = arrayOf(1920,0)
    val ar2 = arrayOf<Int>()
    val ar3 = ar2 + 1
    val arrayArrof = Array<Int?>(8){ null }

    println(array1.javaClass)*/

}
