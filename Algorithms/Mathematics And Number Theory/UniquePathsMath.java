class UniquePathsMath {
    public int uniquePaths(int m, int n) {
        
        //total steps ? m-1 steps right and n-1 to left, so m+n-2
        //so unique ways ? either (m+n-2)C(n-1) or (m+n-2)C(m-1)
        
        int N = m+n-2;
        int r = m-1;
        
        double res = 1;
        
        for(int i=1;i<=r;i++)
            res = res*(N-r+i)/i;
        
        return (int)res;
        
    }
}