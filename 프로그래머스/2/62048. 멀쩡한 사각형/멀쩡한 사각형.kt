class Solution {
    fun solution(w: Int, h: Int): Long {
        val gcd = gcd(w, h)
        return w.toLong() * h.toLong() - (w + h - gcd)
    }

    fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }
}