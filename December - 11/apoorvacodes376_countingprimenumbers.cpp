#include<iostream>
using namespace std;

class prime
{
    public:
    int n;
    int arr[10000];
    int count;

    prime()
    {
        n=0;
        count=0;
    }

    void getinput()
    {
        cout<<"enter the number:";
        cin>>n;
        for(int i=0;i<n;i++)
        {
            arr[i]=i;
        }
    }

    // void find()
    // {
    //     for(int i=2;i<=n/2;i++)
    //     {
    //         if(arr[i]<=1)
    //         {
    //             continue;
    //         }
    //         else if(arr[j]%i==0)
    //         {
    //             count++;
    //         }
    // }
    //     cout<<"total:"<<count;
    // }

    bool isPrime(int num) 
    { 
        if (num <= 1) return false; 
        if (num == 2) return true; 
        if (num % 2 == 0) return false; 
        for (int i = 3; i * i <= num; i += 2) 
        { 
            if (num % i == 0) return false; 
        } 
        return true; 
    } 
    void countPrimes()
    {
        for (int i = 2; i <= n; i++)
        {
            if (isPrime(i))
                count++;
        }
        cout<<count;
    }
};

int main()
{
    class prime p;
    p.getinput();
    p.countPrimes();
    return 0;
}