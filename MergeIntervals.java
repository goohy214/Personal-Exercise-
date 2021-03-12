class Solution {
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<int[]> res = new LinkedList<>();
        
        for (int[] timeslot: intervals) {
            map.put(timeslot[0], map.getOrDefault(timeslot[0], 0) + 1);
            map.put(timeslot[1], map.getOrDefault(timeslot[1], 0) - 1);
        }
        
        int currSum = 0, start = map.firstKey();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {           
            if (currSum == 0) start = entry.getKey();
            if (currSum + entry.getValue() == 0) {
                int[] newInterval = new int[]{start, entry.getKey()};
                res.add(newInterval);
            }
            currSum += entry.getValue();
        }
        
        return res.toArray(new int[res.size()][2]);
    }
}