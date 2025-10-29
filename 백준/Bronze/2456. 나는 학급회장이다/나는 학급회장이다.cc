#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

typedef struct
{
    int idx;
    int total;
    int num3 = 0;
    int num2 = 0;
} Score;

int main()
{
    int n;
    cin >> n;

    vector<Score> arr = vector<Score>(3);
    arr[0].idx = 0;
    arr[1].idx = 1;
    arr[2].idx  =2;
    for (int i = 0; i < n; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        arr[0].total += a;
        arr[1].total += b;
        arr[2].total += c;
        if (a == 3) arr[0].num3++;
        if (a == 2) arr[0].num2++;
        if (b == 3) arr[1].num3++;
        if (b == 2) arr[1].num2++;
        if (c == 3) arr[2].num3++;
        if (c == 2) arr[2].num2++;;
    }

    sort(arr.begin(), arr.end(), [](Score& a, Score& b)
    {
        if (a.total == b.total)
        {
            if (a.num3 == b.num3)
            {
                return a.total > b.total;
            }
            return a.num3 > b.num3;
        }
        return a.total > b.total;
    });

    if (arr[0].total == arr[1].total && arr[0].num3 == arr[1].num3)
    {
        cout << "0 " << arr[0].total;
    } else
    {
        cout << arr[0].idx+1 <<" "<<arr[0].total;
    }
}
