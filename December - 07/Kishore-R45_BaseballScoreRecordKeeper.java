import java.util.*;

public class BaseballScoreRecordKeeper {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] ops = new String[count];
        
        for(int x=0; x<count; x++) ops[x] = sc.next();
        
        ArrayList<Integer> record = new ArrayList<>();
        
        for(int x=0; x<count; x++){
            String curr = ops[x];
            int sz = record.size();
            
            if(curr.equals("C")){
                record.remove(sz-1);
            }
            else if(curr.equals("D")){
                int last = record.get(sz-1);
                record.add(last * 2);
            }
            else if(curr.equals("+")){
                int last = record.get(sz-1);
                int secondLast = record.get(sz-2);
                record.add(last + secondLast);
            }
            else{
                record.add(Integer.parseInt(curr));
            }
        }
        
        int ans = 0;
        for(int val : record) ans += val;
        System.out.println(ans);
        sc.close();
    }
}
