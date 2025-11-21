#include<iostream>

using namespace std;

int main() {
    int idx = 1;
    int n;
    cin >> n;
    while(n!=0) {
        int ans = 0;
        while(n>=5){
            ans += n / 5;
            n /= 5;
        }
        cout << "Case #" << idx << ": " << ans<<"\n";
        idx++;
        cin >> n;
    }
}