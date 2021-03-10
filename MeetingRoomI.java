class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        for(int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int startp = 1, endp = 0;
        while(startp < n && endp < n) {
            if(start[startp] < end[endp]) return false;
            startp ++;
            endp ++;
        }
        return true;  
        
//         Arrays.sort(intervals, ((a,b) -> a[0] - b[0]));
        
//         for(int i = 1; i < intervals.length; i ++) {
//             if(intervals[i][0] < intervals[i-1][1]) return false;
//         }
        
//         return true;
    }
}