#include<iostream>
using namespace std;

int main()
{
int n,start,end;
long long k,sum;
cout<<"enter number of elements in array and target sum:";
cin>>n>>k;
int a[n];

cout<<"Enter array elements:";
for(int i=0;i<n;i++)
    cin>>a[i];
for(int start=0;start<n;start++)
{  long long sum=0;
     for(int end=start;end<n;end++)
       {sum+=a[end];
            if(sum==k)
               {cout<<start<<" "<<end<<"\n";
              
               return 0;
                }
        
       }
}
cout<<"-1 -1"<<endl;
return 0;
}

enter number of elements in array and target sum:7 15
Enter array elements:1 2 3 5 7 1 2 
2 4

7 