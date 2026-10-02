class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length ;
        int cnt =0 ;
        for(int i =0  ; i < n ; i++){
           int  effbat = batteryPercentages[i] - cnt ;
            if(effbat > 0 ){
                cnt++;
            }
        }
        return cnt ;
    }
}