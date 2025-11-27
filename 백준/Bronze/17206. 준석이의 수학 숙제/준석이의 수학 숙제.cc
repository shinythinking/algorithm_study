#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin >> n;
    int input;
    int dp[80001] = {0};
    int idx = 10;
    dp[idx++] = 25;

    for (;idx<=80000; idx++) {
        dp[idx] = dp[idx - 1];
        if (idx %21 == 0) dp[idx] += idx;
        else if (idx %3 == 0) dp[idx] += idx;
        else if (idx %7 == 0) dp[idx] += idx;
    }
    for(int i = 0; i < n ; i++) {
        cin >> input;
        cout << dp[input] << "\n";
    }
}