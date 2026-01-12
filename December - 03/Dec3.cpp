#include <iostream>
#include <vector>
using namespace std;
bool canReachLastStone(vector<int>& stones) 
{
    int maxReach = 0;
    int n = stones.size();
    for (int i = 0; i < n; i++) 
    {
        if (i > maxReach)
            return false;
        maxReach = max(maxReach, i + stones[i]);
        if (maxReach >= n - 1)
            return true;
    }
    return true;
}
int main() 
{
    int n;
    cin >> n;   
    vector<int> stones(n);
    for (int i = 0; i < n; i++) 
    {
        cin >> stones[i];
    }
    if (canReachLastStone(stones))
        cout << "true";
    else
        cout << "false";
    return 0;
}
