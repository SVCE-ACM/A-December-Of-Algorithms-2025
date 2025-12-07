import java.util.*;
class Solution{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int ans =1;
        int count=0;
        for(int i=1;i<a;i++)
        {
            ans = i*i;

            if(ans<=a){
            System.out.print(ans+" ");
            count++;
            }
            else{
                break;
            }
        }
        System.out.println();
        System.out.print(count);
    }
}