import java.util.Scanner;
public class MonishmakerCafeteria {
    public static int cafeteria(int[] students , int[] sandwitches){
        int count0 = 0 , count1 = 0;
        for(int s:students){
            if(s==0) count0++;
            else count1++;
        }
        for(int s:sandwitches){
            if(s==0){
                if(count0==0)break;
                count0--;
            }else{
                if(count1==0)break;
                count1--;
            }
        }
        return count0+count1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] students = new int[n];
        int[] sandwitches = new int[n];
        
        for(int i=0;i<n;i++){
            students[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            sandwitches[i] = sc.nextInt();
        }
        System.out.println(cafeteria(students, sandwitches));
    }    
}