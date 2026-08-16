class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int ans =-1;
        long best = Long.MAX_VALUE;

        for(int i =0; i<drones.length; i++){
            long dist = Math.abs((long)drones[i][0]-target[0]) + Math.abs((long)drones[i][1]-target[1]);

            if(dist<=drones[i][2] && dist<best){
                best = dist;
                ans =i;
            }
        }
        return ans;
    }
}