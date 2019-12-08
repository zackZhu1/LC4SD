class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int curr = groupSizes[i];
            List<Integer> temp = new ArrayList<>();
            if (map.containsKey(curr)) {
                temp = map.get(curr);
            } 
            temp.add(i);
            map.put(curr, temp);
            if (temp.size() == curr) {
                result.add(temp);
                map.remove(curr);
            }
        }
        return result;
    }
}

// can use only one iteration