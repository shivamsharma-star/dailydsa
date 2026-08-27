class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            // String ko char array me convert
            char[] ch = s.toCharArray();

            // characters ko sort karo
            Arrays.sort(ch);

            // sorted characters = key
            String key = new String(ch);

            // key ke andar word add karo
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}