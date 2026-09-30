class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDia = 0 ;
        int maxArea = 0;
        int n = dimensions.length;
        for(int i = 0 ; i < n;i++){
            int length =  dimensions[i][0]  ;
            int breadth = dimensions[i][1] ;
            int dia = length * length + breadth * breadth ;
            int area = length * breadth ;
            if(maxDia < dia){
               maxDia = dia ;
               maxArea = area ;
            }else if (maxDia == dia){
                maxArea = Math.max(area,maxArea);
            }
        }
        return maxArea ;
    }
}