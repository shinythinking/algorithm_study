fun main() {
    val num = readln().toInt()
    val dict = mutableMapOf<Char, MutableSet<String>>()
    val matrix = mutableListOf(
        "ba", "ca", "ga", "la", "na", "pa", "ra", "ta", "db", "nb", "pb", "rb", "sb", "tb", "yb", "ac",
        "sc", "tc", "cd", "gd", "md", "nd", "pd", "be", "ce", "fe", "ge", "he", "ne", "re", "se", "te",
        "xe", "cf", "hf", "rf", "ag", "hg", "mg", "rg", "sg", "bh", "rh", "th", "bi", "li", "ni", "si",
        "ti", "bk", "al", "cl", "fl", "tl", "am", "cm", "fm", "pm", "sm", "tm", "cn", "in", "mn", "rn",
        "sn", "zn", "co", "ho", "mo", "no", "po", "np", "ar", "br", "cr", "er", "fr", "ir", "kr", "lr",
        "pr", "sr", "zr", "as", "cs", "ds", "es", "hs", "os", "at", "mt", "pt", "au", "cu", "eu", "lu",
        "pu", "ru", "lv", "dy", "h", "b", "c", "n", "o", "f", "p", "s", "k", "v", "y", "i", "w", "u"
    )
    matrix.forEachIndexed { i, it ->
        val key = it[0]
        if (dict[key] == null) dict[key] = mutableSetOf(matrix[i])
        else dict[key]!!.add(matrix[i])
    }
    val ans = buildString {
        repeat(num) {
            val target = readln()
            val visited = BooleanArray(target.length + 1)
            val queue = ArrayDeque<Int>()
            queue.addLast(0)
            var success = false
            while (queue.isNotEmpty()) {
                val index = queue.removeFirst()
                if (index == target.length) {
                    success = true
                    break
                }
                val targetChar = target.slice(index..index)
                val mol = dict[targetChar[0]] ?: continue
                if(mol.contains(targetChar)) {
                    if(!visited[index+1]) {
                        visited[index+1] = true
                        queue.addLast(index + 1)
                    }
                }

                if(target.lastIndex >= index + 1) {
                    val targetCharLong = target.slice(index..index + 1)
                    if (mol.contains(targetCharLong)) {
                        if(!visited[index+2]) {
                            visited[index+2] = true
                            queue.addLast(index + 2)
                        }
                    }
                }
            }
            if (success) appendLine("YES")
            else appendLine("NO")
        }
    }
    println(ans)
}