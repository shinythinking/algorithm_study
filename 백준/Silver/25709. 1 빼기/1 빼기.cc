#include <iostream>

using namespace std;

int ans = 0;

int eraseOne(int n) {
    string s = std::to_string(n);
    for (int i = 0; i < s.size();) {
        if (s[i] == '1') {
            s.erase(i, 1);
            ans++;
        } else {
            i++;
        }
    }

    if (s.empty()) {
        return 0;
    } else {
        return stoi(s);
    }
}

int main() {
    int n;
    cin >> n;
    while (n != 0) {
        n = eraseOne(n);
        if (n == 0) break;
        n -= 1;
        ans++;
    }

    cout << ans << endl;
}
