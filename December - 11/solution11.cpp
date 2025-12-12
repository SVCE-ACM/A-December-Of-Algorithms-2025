#include<iostream>
#include<vector>
using namespace std;
int main()
{
int n;
cout<<"enter the limit of numbers:";
cin>>n;
vector<bool> isprime(n+1,true);
isprime[1]=isprime[0]=false;
for(int p=2;p*p<=n;p++)
{if(isprime[p])
 {for(int i=p*p;i<=n;i+=p)
  isprime[i]=false;
 }
}
 int count=0;
 for(int i=2;i<=n;i++)
{ if(isprime[i])
 {
 count++;}
}
 cout<<"total no of primes less than limit is :"<<count<<endl;
 return 0;
}