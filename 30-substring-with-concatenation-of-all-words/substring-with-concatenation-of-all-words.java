
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int k = words[0].length();
        int m = words.length;
        int total = k * m;

        if (n < total) return ans;

        Map<String, Integer> ids = new HashMap<>();
        int[] required = new int[m];
        int unique = 0;

        for (String w : words) {
            Integer id = ids.get(w);

            if (id == null) {
                id = unique++;
                ids.put(w, id);
            }

            required[id]++;
        }

        for (int offset = 0; offset < k; offset++) {
            int left = offset;
            int count = 0;
            int[] seen = new int[unique];

            for (int right = offset; right + k <= n; right += k) {
                String chunk = s.substring(right, right + k);
                Integer id = ids.get(chunk);

                if (id == null) {
                    Arrays.fill(seen, 0);
                    count = 0;
                    left = right + k;
                    continue;
                }

                seen[id]++;
                count++;

                while (seen[id] > required[id]) {
                    String leftChunk = s.substring(left, left + k);
                    int leftId = ids.get(leftChunk);

                    seen[leftId]--;
                    count--;
                    left += k;
                }

                if (count == m) {
                    ans.add(left);

                    String leftChunk = s.substring(left, left + k);
                    int leftId = ids.get(leftChunk);

                    seen[leftId]--;
                    count--;
                    left += k;
                }
            }
        }

        return ans;
    }
}
