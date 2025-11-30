#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int vertex, edge, start;
    long long ans = 0;
    cin >> vertex >> edge >> start;
    vector<int> graph[vertex + 1];
    vector<bool> visited(vertex + 1, false);
    queue<pair<int, int>> queue;
    for (int i = 0 ; i < edge ; i++) {
        int s, e;
        cin >> s >> e;
        graph[s].push_back(e);
        graph[e].push_back(s);
    }
    queue.emplace(start, 0);
    visited[start] = true;

    for (int i = 1; i <= vertex; i++) {
        sort(graph[i].begin(), graph[i].end());
    }

    int order = 1;

    while (!queue.empty()) {
        auto[cur, dep] = queue.front();
        ans += (long long)order * dep;
        order++;
        queue.pop();
        for (int i = 0; i<graph[cur].size(); i++) {
            int next = graph[cur][i];
            if (visited[next]) continue;
            visited[next] = true;
            queue.emplace(next, dep + 1);
        }
    }
    cout << ans << endl;
}
