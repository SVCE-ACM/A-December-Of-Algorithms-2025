#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
int main()
{
    int N;
    cin >> N;
    vector<int> arr(N);
    for(int i=0;i<N;i++)
        cin >> arr[i];
    int duplicate=-1, missing=-1;
    for(int i=0;i<N;i++)
    {
        int idx=abs(arr[i])-1;
        if(arr[idx]<0)
            duplicate=abs(arr[i]);
        else
            arr[idx]=-arr[idx];
    }
    for(int i=0;i<N;i++)
        if(arr[i]>0)
            missing=i+1;
    cout<<"Missing Number: "<<missing<<"\n";
    cout<<"Duplicate Number: "<<duplicate;
    return 0;
}
