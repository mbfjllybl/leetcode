package Java.substringWithConcatenationOfAllWords;

import java.util.*;

class Pair {
    int x;
    String s;

    public Pair(int x, String s) {
        this.x = x;
        this.s = s;
    }

    public Pair() {
    }
}

class Solution {
    Map<String, Integer> s1 = new HashMap<>();
    Map<String, Integer> map = new HashMap<>();
    Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
        @Override
        public int compare(Pair pair, Pair t1) {
            if (pair.x >= t1.x) return 1;
            else return -1;
        }
    });

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) s1.put(words[i], s1.getOrDefault(words[i], 0) + 1);
        int n = words[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < s.length(); j += n) {
                String tmp = s.substring(j, j + n);
                map.clear();
                s1.clear();
                if (!s1.containsKey(tmp)) {
                    queue.clear();
                } else {
                    if (map.getOrDefault(tmp, 0) == s1.get(tmp)) {
                        while (!queue.element().s.equals(tmp)) queue.poll();
                        queue.poll();
                        map.put(tmp, j);
                        queue.offer(new Pair(j, tmp));
                    } else {
                        map.put(tmp, j);
                        queue.offer(new Pair(j, tmp));
                    }
                    if (map.size() == words.length) {
                        ans.add(queue.peek().x);
                        queue.clear();
                        map.clear();
                    }
                }
            }
        }
        return ans;
    }
}