#include <iostream>
#include <vector>
#include <string>
using namespace std;
int main()
{
    int n;
    cin >> n;
    vector<string> ops(n);
    for(int i=0;i<n;i++)
        cin >> ops[i];
    vector<int> scores;
    for(string op:ops)
    {
        if(op=="C")
            scores.pop_back();
        else if(op=="D")
            scores.push_back(2*scores.back());
        else if(op=="+")
            scores.push_back(scores[scores.size()-1]+scores[scores.size()-2]);
        else
            scores.push_back(stoi(op));
    }
    int sum=0;
    for(int x:scores)
        sum+=x;
    cout<<sum;
    return 0;
}
