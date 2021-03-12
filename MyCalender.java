class MyCalendarThree {
    List<Integer> startList;
    List<Integer> endList;

    public MyCalendarThree() {
        startList = new LinkedList<>();
        endList = new LinkedList<>();
    }
    
    public int book(int start, int end) {
        startList.add(start);
        endList.add(end);
        
        Collections.sort(startList);
        Collections.sort(endList);
        
        int startPoint = 0, endPoint = 0, cnt = 0, available = 0;
        while (startPoint < startList.size()) {
            if (startList.get(startPoint) < endList.get(endPoint)) {
                if(available > 0) available--;
                else cnt++;
                startPoint++;
            } else {
                available++;
                endPoint++;
            }
        }
        
        return cnt;
    }
}

class MyCalendarThree {
    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        int max = Integer.MIN_VALUE, cnt = 0;
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        for(int value: map.values())
            max = Math.max(max, cnt += value);
                  
        return max;
    }
    
}




/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */