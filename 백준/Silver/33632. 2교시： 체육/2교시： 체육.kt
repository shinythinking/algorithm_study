fun main(){
    val (w, h) = readln().split(" ").map { it.toInt() }
    val (cW, cH) = readln().split(" ").map { it.toInt() }
    val (fW, fH, tW, tH) = readln().split(" ").map { it.toInt() }
    if (cH < fH) {
        println("0.0")
        return
    }

    var shootStart = 0.0
    if (cW > fW) {
        shootStart = cW - (cH * (cW - fW) / (cH - fH).toDouble())
        if (shootStart < 0) shootStart = 0.0
    } else {
        shootStart = cW - cH * (fW-cW) / (fH-cH).toDouble()
        if (shootStart > w) shootStart = w.toDouble()
    }
    var shootEnd = 0.0
    if (cW < tW) {
        shootEnd = cW - cH * (tW-cW) / (fH-cH).toDouble()
        if (shootEnd > w) shootEnd = w.toDouble()
    } else {
        shootEnd = cW - (cH * (cW - tW) / (cH - fH).toDouble())
        if (shootEnd < 0) shootEnd = 0.0
    }

    println((shootEnd - shootStart) / w.toDouble())
}