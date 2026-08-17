class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder diary = new StringBuilder();
        int n  = digits.length();
        int idx = 0 ;

        letter(digits,n,idx,diary,ans,map);
        return ans ;
    }
    public void letter(String digits, int n , int idx ,StringBuilder res , List<String>ans, Map<Character, String> map){
        if(idx == n ){
            ans.add(res.toString());
            return ;
        }
        char str = digits.charAt(idx);
        String choice = map.get(str);
        for(int i = 0 ; i < choice.length() ; i++){
            res.append(choice.charAt(i));
            letter(digits,n,idx+1,res,ans,map);
            res.deleteCharAt(res.length()-1);
        }
    }
}