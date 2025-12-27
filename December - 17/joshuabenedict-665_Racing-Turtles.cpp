#include <bits/stdc++.h>
using namespace std;

int turtleFleets(int target, int n, vector<int>& position, vector<int>& speed) {
    if (n == 0) return 0;
    vector<pair<int, double>> turtles;
    for (int i = 0; i < n; i++) {
        double time = (double)(target - position[i]) / speed[i];
        turtles.push_back({position[i], time});
    }
    sort(turtles.begin(), turtles.end(), greater<>());
    int fleets = 0;
    double maxTime = 0.0;
    for (auto &t : turtles) {
        if (t.second > maxTime) {
            fleets++;
            maxTime = t.second;
        }
    }
    return fleets;
}

int main() {
    int target, n;
    cin >> target >> n;
    if (n == 0) {
        cout << "No turtle fleets formed.";
        return 0;
    }
    vector<int> position(n), speed(n);
    for (int i = 0; i < n; i++)
        cin >> position[i];
    for (int i = 0; i < n; i++)
        cin >> speed[i];
    int result = turtleFleets(target, n, position, speed);
    cout << "The number of turtle fleets is: " << result;
    return 0;
}
