class Solution {
    public int solution(int X, int Y, int D) {
        int Z = Y-X;
        
        return Z%D==0 ? Z/D : Z/D+1;
    }
}
//O(1)
