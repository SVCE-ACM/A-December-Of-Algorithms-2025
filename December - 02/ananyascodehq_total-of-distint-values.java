class Solution{
    public void printTable(int N){
        int width = Integer.toBinaryString(N).length();
        for(int i = 1; i <=N; i++){
            String decString = Integer.toString(i);
            String octalString = Integer.toOctalString(i);
            String hexString = Integer.toHexString(i);
            String bString = Integer.toBinaryString(i);
            System.out.printf("%" + width + "s %" + width + "s %" + width + "s %" + width + "s\n",decString, octalString, hexString, bString);
        }
    }

     public static void main(String[] args) {
        Solution s = new Solution();
        s.printTable(6); 
    }
}