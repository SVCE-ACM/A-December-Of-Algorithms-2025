import java.util.*;

public class CafeteriaQueueChallenge {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> students = new LinkedList<>();
        LinkedList<Integer> food = new LinkedList<>();
        
        for(int x=0; x<n; x++) students.add(sc.nextInt());
        for(int x=0; x<n; x++) food.add(sc.nextInt());
        
        int tries = 0;
        
        while(students.size() > 0 && tries < students.size()){
            int frontStudent = students.peekFirst();
            int topFood = food.peekFirst();
            
            if(frontStudent == topFood){
                students.removeFirst();
                food.removeFirst();
                tries = 0;
            }
            else{
                students.addLast(students.removeFirst());
                tries++;
            }
        }
        
        System.out.println(students.size());
        sc.close();
    }
}
