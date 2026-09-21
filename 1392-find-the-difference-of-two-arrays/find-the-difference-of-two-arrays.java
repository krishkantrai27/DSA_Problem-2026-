class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<>();
Set<Integer> ans2 = new HashSet<>();
HashSet<Integer> set = new HashSet<>();
HashSet<Integer> set2 = new HashSet<>();
List<List<Integer>> res = new ArrayList<>();

for(int i : nums2){
    set.add(i);
}
for(int i : nums1){
    if(!set.contains(i)){
        ans.add(i);
    }
}
for(int i : nums1){
    set2.add(i);
}
for(int i : nums2){
    if(!set2.contains(i)){
        ans2.add(i);
    }
}

res.add(new ArrayList<>(ans));
res.add(new ArrayList<>(ans2));
return res;
    }
}