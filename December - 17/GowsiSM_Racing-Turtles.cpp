#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int countTurtleFleets(int target, vector<int>& position, vector<int>& speed) {
    int n = position.size();
    if (n == 0) return 0;

    vector<pair<int, double>> turtles;

    for (int i = 0; i < n; i++) {
        double time = (double)(target - position[i]) / speed[i];
        turtles.push_back({position[i], time});
    }

    sort(turtles.begin(), turtles.end(),
         [](auto &a, auto &b) {
             return a.first > b.first;
         });

    int fleets = 0;
    double maxTime = 0.0;

    for (int i = 0; i < n; i++) {
        if (turtles[i].second > maxTime) {
            fleets++;
            maxTime = turtles[i].second;
        }
    }

    return fleets;
}

int main() {
    int target, n;

    cout << "Enter target position: ";
    cin >> target;

    cout << "Enter number of turtles: ";
    cin >> n;

    if (n == 0) {
        cout << "No turtle fleets formed." << endl;
        return 0;
    }

    vector<int> position(n), speed(n);

    cout << "Enter positions: ";
    for (int i = 0; i < n; i++)
        cin >> position[i];

    cout << "Enter speeds: ";
    for (int i = 0; i < n; i++)
        cin >> speed[i];

    int result = countTurtleFleets(target, position, speed);
    cout << "The number of turtle fleets is: " << result << endl;

}
