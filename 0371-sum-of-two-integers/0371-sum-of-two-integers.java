class Solution {
    public int getSum(int a, int b) {
        
        // idea is xor and use AND to take care of carry
        
        while(b != 0){
            int _a = a;
            a = a ^ b;
            b = (_a & b) << 1;
        }
        
        return a;
           
    }
}