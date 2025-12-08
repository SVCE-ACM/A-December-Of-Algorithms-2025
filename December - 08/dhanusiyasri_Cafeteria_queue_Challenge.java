import java.util.*;
public class dhanusiyasri_Cafeteria_queue_Challenge {
    public static int cafeteriaQueueChallenge(int[] students,int[] sandwiches)
    {
        int[] visited=new int[students.length];
        visited[0]=0;
        int studentsnotServed=0;
        int count=0;
        int i=0,k=0;
        while(count<sandwiches.length){
            if(visited[i]==0){
                if(students[i]==sandwiches[count]){
                    visited[i]=1;
                    count++;
                    k=0;
                }
            }
            i++;
            if(i==students.length)
            {    i=0;
                 k++;
            }
            if(k==2)
                break;
        }
        for(int j=0;j<visited.length;j++){
            if(visited[j]==0)
                studentsnotServed++;
        }
        return studentsnotServed;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String[] input1=sc.nextLine().trim().split(",");
        String[] input2=sc.nextLine().trim().split(",");
        int[] students=new int[input1.length];
        int[] sandwiches=new int[input2.length];
        for(int i=0;i<input1.length;i++)
            students[i]=Integer.parseInt(input1[i]);
        for(int i=0;i<input2.length;i++)
            sandwiches[i]=Integer.parseInt(input2[i]);
        int result=cafeteriaQueueChallenge(students,sandwiches);
        System.out.println(result);
        sc.close();
    }
}