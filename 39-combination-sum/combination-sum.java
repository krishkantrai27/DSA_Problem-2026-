class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        int sum = 0 ;
        int idx = 0 ;
        int n = candidates.length ;
        combination(candidates,target,n , idx , sum ,diary,ans);
        return ans ;
    }
    void combination(int [] arr,int target,int n , int idx , int sum , List<Integer> diary , List<List<Integer>>ans){
        if(idx == n){
           return;
        }
        if(sum == target){
            ans.add(new ArrayList<>(diary));
            return;
            }
        // Not take Matlab us coice ko agar mai nahi leta hu tab kya hoga
        combination(arr,target,n,idx+1,sum,diary,ans);
        //Take Agr us choice ko leta hu tb
        if(arr[idx] + sum <= target){
            diary.add(arr[idx]);
            sum += arr[idx];
            combination(arr,target,n,idx,sum,diary,ans);
            diary.remove(diary.size() -1);
            sum -= arr[idx];
        }
    }
}