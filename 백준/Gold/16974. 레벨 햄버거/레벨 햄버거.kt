import java.util.Scanner

// 버거의 총 길이와 패티의 개수를 저장할 배열
val burger = LongArray(51)
val patty = LongArray(51)

/**
 * n: 현재 버거의 레벨
 * x: 먹은 재료의 개수
 */
fun countPatty(n: Int, x: Long): Long {
    // 레벨 0 버거는 패티 한 장뿐임
    if (n == 0) return if (x <= 0) 0 else 1

    // 1. 첫 번째 재료는 항상 '번(Bun)'임
    if (x == 1L) {
        return 0
    } 
    // 2. 첫 번째 '번' + 레벨 (n-1) 버거 범위 내에 있을 때
    else if (x <= 1 + burger[n - 1]) {
        return countPatty(n - 1, x - 1)
    } 
    // 3. 정확히 중간에 있는 '패티'까지 먹었을 때
    else if (x == 1 + burger[n - 1] + 1) {
        return patty[n - 1] + 1
    } 
    // 4. 중간 패티를 넘어 두 번째 레벨 (n-1) 버거 범위 내에 있을 때
    else if (x <= 1 + burger[n - 1] + 1 + burger[n - 1]) {
        return patty[n - 1] + 1 + countPatty(n - 1, x - (1 + burger[n - 1] + 1))
    } 
    // 5. 버거 전체를 다 먹었을 때 (마지막 '번' 포함)
    else {
        return patty[n - 1] + 1 + patty[n - 1]
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    
    if (!sc.hasNextInt()) return
    val n = sc.nextInt()
    val x = sc.nextLong()

    // 초기값 설정 (레벨 0)
    burger[0] = 1
    patty[0] = 1

    // 각 레벨별 버거의 총 길이와 패티 개수 미리 계산 (DP)
    for (i in 1..n) {
        // 레벨 n 버거 = 번 + 레벨 n-1 + 패티 + 레벨 n-1 + 번
        burger[i] = 1 + burger[i - 1] + 1 + burger[i - 1] + 1
        // 레벨 n 패티 = 레벨 n-1 패티 + 1(중간 패티) + 레벨 n-1 패티
        patty[i] = patty[i - 1] + 1 + patty[i - 1]
    }

    println(countPatty(n, x))
}