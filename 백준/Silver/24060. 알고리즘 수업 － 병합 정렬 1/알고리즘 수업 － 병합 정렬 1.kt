val ans = mutableListOf<Int>()
fun ms(l: MutableList<Int>, p: Int, r: Int) {
    if (p < r) {
        val q = (p + r) / 2
        ms(l, p, q)
        ms(l, q + 1, r)
        merge(l, p, q, r)
    }

}

fun merge(l: MutableList<Int>, p: Int, q: Int, r: Int) {
    var i = p
    var j = q + 1
    val tmp = mutableListOf<Int>()
    while (i < q + 1 && j <= r) {
        if (l[i] < l[j]) {
            tmp.add(l[i])
            ans.add(l[i])
            i++
        } else {
            tmp.add(l[j])
            ans.add(l[j])
            j++
        }
    }
    while(i < q+1) {
        tmp.add(l[i])
        ans.add(l[i])
        i++
    }
    while(j <= r) {
        tmp.add(l[j])
        ans.add(l[j])
        j++
    }
    var idx = 0
    for(s in p..r){
        l[s] = tmp[idx++]
    }
}

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val l = readln().split(" ").map { it.toInt() }.toMutableList()

    ms(l, 0, l.lastIndex)
    try{
        println(ans[m-1])
    } catch (e: Exception) {
        println(-1)
    }}