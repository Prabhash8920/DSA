class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxlight =0;
    for(int light:lights){
        maxlight = Math.max(maxlight,light);
    }
    int ans =0;

    for(int time: arrivalTime){
        int r = time%period;
        int waiting;
        if(r<maxlight){
            waiting =0;
        } else{
            waiting = period -r;
        }
        ans = Math.max(ans,waiting);

    } 
    return ans;

    }
}