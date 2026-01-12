import java.util.*;

public class MagicalTreasureChestParser {
    static int pos;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        
        pos = 0;
        Object parsed = parseChest(str);
        System.out.println(convertToString(parsed));
        sc.close();
    }
    
    static Object parseChest(String s){
        if(pos >= s.length()) return null;
        
        char ch = s.charAt(pos);
        
        if(ch == '['){
            pos++;
            ArrayList<Object> items = new ArrayList<>();
            
            while(pos < s.length() && s.charAt(pos) != ']'){
                if(s.charAt(pos) == ','){
                    pos++;
                    continue;
                }
                items.add(parseChest(s));
            }
            pos++;
            return items;
        }
        else{
            String numStr = "";
            while(pos < s.length()){
                char c = s.charAt(pos);
                if(Character.isDigit(c) || c == '-'){
                    numStr += c;
                    pos++;
                }
                else break;
            }
            return Integer.parseInt(numStr);
        }
    }
    
    static String convertToString(Object obj){
        if(obj instanceof Integer){
            return obj.toString();
        }
        
        ArrayList<Object> list = (ArrayList<Object>) obj;
        String result = "[";
        for(int x=0; x<list.size(); x++){
            result += convertToString(list.get(x));
            if(x < list.size()-1) result += ",";
        }
        result += "]";
        return result;
    }
}
