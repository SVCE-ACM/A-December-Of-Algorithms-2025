import java.util.Scanner;

public class dhanusiyasri_mirror_necklace_check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==0){
            sc.close();
            System.out.println("The necklace is empty.");
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<n/2;i++){
            if(arr[i]!=arr[n-1-i]){
                System.out.println("The necklace is not mirrored.");
                sc.close();
                return;
            }
        }
        System.out.println("The necklace is mirrored.");
        sc.close();
    }
} 
/*
Input format:
The first line contains an integer n, the number of beads in the necklace.
The second line contains n space-separated integers representing the beads. 
Output format:
Print "The necklace is mirrored." if the necklace is mirrored, otherwise print "The necklace is not mirrored." If the necklace is empty (n=0), print "The necklace is empty."
Example input: 
5
1 2 3 2 1
Example output:
The necklace is mirrored.
*/