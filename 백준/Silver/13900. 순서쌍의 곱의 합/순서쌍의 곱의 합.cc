#include <iostream>

using namespace  std;

int main() {
    int n;
    cin >> n;
    long long arr[n];
    cin >> arr[0];
    int tmps[n];
    tmps[0] = arr[0];
    for(int i =1;i<n;i++) {
        int tmp;
        cin >> tmp;
        tmps[i] = tmp;
        arr[i] = arr[i-1]+tmp;
    }
    long long ans = 0;
    for(int i = 0 ; i < n ; i ++){
        ans += tmps[i] * (arr[n-1] - arr[i]);
    }
    cout << ans;
}