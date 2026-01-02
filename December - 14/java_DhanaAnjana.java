import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_DhanaAnjana {
    interface NestedInteger {
        boolean isInteger();
        Integer getInteger();
        List<NestedInteger> getList();
    }
    
    static class NestedIntegerImpl implements NestedInteger {
        private Integer value;
        private List<NestedInteger> list;
        
        NestedIntegerImpl(Integer value) {
            this.value = value;
        }
        
        NestedIntegerImpl() {
            this.list = new ArrayList<>();
        }
        
        public void add(NestedInteger ni) {
            list.add(ni);
        }
        
        @Override
        public boolean isInteger() {
            return value != null;
        }
        
        @Override
        public Integer getInteger() {
            return value;
        }
        
        @Override
        public List<NestedInteger> getList() {
            return list;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        
        NestedInteger result = deserialize(s);
        System.out.println(formatOutput(result));
        
        scanner.close();
    }
    
    static NestedInteger deserialize(String s) {
        s = s.trim();
        
        if (!s.startsWith("[")) {
            return new NestedIntegerImpl(Integer.parseInt(s));
        }
        
        NestedIntegerImpl result = new NestedIntegerImpl();
        int level = 0;
        int start = 1;
        
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '[') {
                level++;
            } else if (c == ']') {
                level--;
                if (level < 0) {
                    if (start < i) {
                        String token = s.substring(start, i).trim();
                        if (!token.isEmpty()) {
                            result.add(new NestedIntegerImpl(Integer.parseInt(token)));
                        }
                    }
                }
            } else if (c == ',' && level == 0) {
                if (start < i) {
                    String token = s.substring(start, i).trim();
                    if (!token.isEmpty()) {
                        if (token.startsWith("[")) {
                            result.add(deserialize(token));
                        } else {
                            result.add(new NestedIntegerImpl(Integer.parseInt(token)));
                        }
                    }
                }
                start = i + 1;
            }
        }
        
        return result;
    }
    
    static String formatOutput(NestedInteger ni) {
        if (ni.isInteger()) {
            return ni.getInteger().toString();
        }
        
        StringBuilder sb = new StringBuilder("[");
        List<NestedInteger> list = ni.getList();
        
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) sb.append(",");
            sb.append(formatOutput(list.get(i)));
        }
        
        sb.append("]");
        return sb.toString();
    }
}
