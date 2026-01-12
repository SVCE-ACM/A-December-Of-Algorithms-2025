#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;
int main()
{
    int n;
    cin >> n;
    vector<long long> arr(n);
    unordered_map<long long,int> freq;
    for(int i=0;i<n;i++)
    {
        cin >> arr[i];
        freq[arr[i]]++;
    }
    long long sum=0;
    for(auto &p:freq)
        if(p.second==1)
            sum+=p.first;
    cout<<sum;
    return 0;
}
