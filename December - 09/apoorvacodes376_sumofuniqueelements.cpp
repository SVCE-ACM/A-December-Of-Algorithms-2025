#include<iostream>
using namespace std;

class unique
{
    public:
    int n;
    int arr[1000];
    int sum;

    unique()
    {
        n=0;
        sum=0;
    }

    void getinput()
    {
        cout<<"enter the number of elements:";
        cin>>n;
        cout<<"enter the elements:";
        for(int i=0;i<n;i++)
        {
            cin>>arr[i];
        }
    }

    // int find()
    // {
    //     for(int i=0;i<n;i++)
    //     {
    //         for(int j=1;j<n;j++)
    //         {
    //             if(arr[i]==arr[j]) continue;
    //             else {
    //                 if (arr[i]!=arr[n-1]) 
    //                 sum+=arr[i];
    //                 break;
    //             }
    //         }
    //     }
    //     cout<<endl<<"sum:"<<sum<<endl;
    //     return sum;
    // }

    // int find()
    // {
    //     for(int i=0;i<n;i++)
    //     {
    //         for(int j=1;j<n;j++)    
    //         {
    //             if(arr[j]==arr[i])
    //             {
    //                 arr[i]=0;
    //                 arr[j]=0;
    //             }
                
    //         }
    //         sum+=arr[i];
    //     }
    //     cout<<endl<<"sum:"<<sum<<endl;
    //     return sum;
    // }

    int find() 
    { 
        for (int i = 0; i < n; i++) 
        { 
            int count = 0; 
            for (int j = 0; j < n; j++) 
            { 
                if (arr[i] == arr[j]) 
                { 
                    count++; 
                } 
            } 
            if (count == 1) 
            { 
                sum += arr[i]; 
            } 
        } 
        cout << endl << "sum of unique elements: " << sum << endl; 
        return sum; 
    }

};

int main(){
    cout<<"Hello world!"<<endl;
    unique u;
    // u.unique();
    u.getinput();
    u.find();
    return 0;
}