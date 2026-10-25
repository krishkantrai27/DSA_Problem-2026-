class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int [] freqP = new int[26];
        int [] freqS = new int[26];
        if(p.length() > s.length()) return list;
        //Frequency to store Element
        for(int i = 0; i < p.length() ; i++){
            freqP[p.charAt(i) - 'a']++;
        }
        int i = 0 ;
        int j = 0 ;
        while(j < s.length()){
            freqS[s.charAt(j) - 'a']++;
            if(i + j + 1 > p.length()){
                freqS[s.charAt(i) - 'a']--;
                i++;
            }
            if(Arrays.equals(freqS,freqP)){
                list.add(i);
            }
            j++;
        }
        return list;
    }
}