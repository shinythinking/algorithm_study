#include <iostream>
#include <cstring>
using namespace std;
int a[101],b[101],ans[101];
 
int main() {
    int m,n,target=0;
    cin >> n >> m;
    for (int i = 1; i <= m; i++){
        cin >> a[i];
    }
 
    for (int i = 1; i <= m; i++){
        target = a[i];
        int cnt = 0;
        for (int j = 1; j <= n; j++){
            cin >> b[j];
        }
        for (int j = 1; j <= n; j++){
            if (target == b[j])
                ans[j]++;
            else
                cnt++;
        }
        ans[a[i]] += cnt;
    }
    for (int i = 1; i <= n; i++)
        cout << ans[i] << '\n';
}
