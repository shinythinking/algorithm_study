fun main(){
    val l = readln()
    val target = readln()
    val dict = IntArray(target.length + 1)
    dict[0] = 1
    for (i in target.indices) {
        dict[i + 1] = (dict[i] * l.length) % 900528
    }
    var ans = 1L

    for(i in 1 until target.length){
        val tmp = dict[i]
        ans = (ans + tmp)%900528
    }

    for(i in target.indices){
        val index = l.toCharArray().indexOf(target[i])
        val tmp = (index * dict[target.length - i -1]!!)%900528
        ans = (ans + tmp)%900528
    }
    println(ans%900528)
}