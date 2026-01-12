#include <iostream>
#include <vector>
using namespace std;
int main()
{
    int n;
    cin >> n;
    vector<int> students(n), sandwiches(n);
    for(int i=0;i<n;i++)
        cin >> students[i];
    for(int i=0;i<n;i++)
        cin >> sandwiches[i];
    int front=0, count=0;
    while(front<n && count<n)
    {
        if(students[front]==sandwiches[0])
        {
            sandwiches.erase(sandwiches.begin());
            students.erase(students.begin()+front);
            n--;
            count=0;
        }
        else
        {
            front++;
            count++;
            if(front==n) front=0;
        }
    }
    cout<<n;
    return 0;
}
