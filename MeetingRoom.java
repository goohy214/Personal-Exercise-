class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        for(int i = 0; i< intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }            
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int startp = 0, endp = 0, available = 0, cnt = 0;
        while(startp < n && endp < n) {
            if(start[startp] < end[endp]) { 
                if(available > 0) available --;
                else cnt ++;
                startp ++;
            } else {
                endp ++;
                available ++;
            }
            // if(start[startp] < end[endp]){
            //     cnt++;
            //     startp++;
            // } else{
            //     available = Math.max(available, cnt);
            //     cnt--;
            //     endp++;
            // }
        }
        
        return cnt;
        // return Math.max(available, cnt);
    }
}



