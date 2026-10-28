class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>() ;
        HashMap<Integer,Integer> map = new HashMap<>() ;
        for(int n : nums2){
            while(!st.isEmpty() && st.peek() < n){
                map.put(st.pop(),n);
            }
            st.push(n);
        }
        // Ab jo bhi element back gaye hai Stack me unka koi bhi next greater integer nhi hai
        while(!st.isEmpty()){
            map.put(st.pop(),-1);
        }
        int [] res = new int[nums1.length] ;
        for(int i = 0; i < res.length ; i++){
            res[i] = map.get(nums1[i]);
        }
        return res ;
    }
}