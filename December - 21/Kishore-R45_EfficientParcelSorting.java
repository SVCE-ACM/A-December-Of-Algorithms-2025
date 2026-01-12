import java.util.*;

public class EfficientParcelSorting {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        LinkedList<Integer> parcels = new LinkedList<>();
        for(int x=0; x<n; x++) parcels.add(sc.nextInt());
        
        ArrayList<Integer> sorted = new ArrayList<>();
        
        while(!parcels.isEmpty()){
            int smallest = Integer.MAX_VALUE;
            for(int p : parcels){
                if(p < smallest) smallest = p;
            }
            
            while(parcels.peekFirst() != smallest){
                parcels.addLast(parcels.removeFirst());
            }
            
            sorted.add(parcels.removeFirst());
        }
        
        String out = "";
        for(int x=0; x<sorted.size(); x++){
            out += sorted.get(x);
            if(x < sorted.size()-1) out += " ";
        }
        System.out.println(out);
        sc.close();
    }
}
