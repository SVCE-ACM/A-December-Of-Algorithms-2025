import java.util.*;

public class Day07_BaseballScoreRecordKeeper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        line = line.replaceAll("[\[\]"]", "");
        if(line.isEmpty()){System.out.println(0);sc.close();return;}
        String[] parts = line.split(",");
        Deque<Integer> st = new ArrayDeque<>();
        for(String p: parts){p=p.trim(); if(p.equals("+")){int a=st.pollLast();int b=st.peekLast();st.addLast(a);st.addLast(a+b);} else if(p.equals("D")){st.addLast(st.peekLast()*2);} else if(p.equals("C")){st.pollLast();} else {st.addLast(Integer.parseInt(p));}}
        int sum=0; for(int v:st) sum+=v; System.out.println(sum); sc.close();
    }
}
