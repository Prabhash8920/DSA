class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] num = new int[nums1.length + nums2.length];

        int k = 0;

        for (int i = 0; i < nums1.length; i++) {
            num[k++] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            num[k++] = nums2[i];
        }

        Arrays.sort(num);

        int n = num.length;

        if (n % 2 == 0) {
            return (num[n/2 - 1] + num[n/2]) / 2.0;
        } else {
            return num[n/2];
        }
    }
}