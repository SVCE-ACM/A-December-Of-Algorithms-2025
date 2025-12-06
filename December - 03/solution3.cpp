
#include <iostream>
#include<algorithm>
#include<vector>
using namespace std;
int main() {
int i, n,farthest=0;
cout<<"Enter the number of stones: ";
cin>>n;
vector<int> stones(n);
cout<<"Enter the array of stones:";

for(i=0;i<n;i++)
{cin>>stones[i];
}
for(i=0;i<=farthest&&i<n;i++)
 {   farthest=max(farthest,i+stones[i]);
 }
 if(farthest>=n-1)
     cout<<"last stone can be reached";
else
     cout<<"last stone can't be reached";
 
    return 0;
}

Enter the number of stones: 5
Enter the array of stones:3 2 1 0 4
last stone can't be reached