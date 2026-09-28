class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int depth = 0 ;
        int ans = 0 ;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
                depth++;
            }else if(ch == ')' && stack.peek() == '('){
                ans = Math.max(depth,ans);
                stack.pop();
                depth--;
            }
        }
        return ans ;
    }
}