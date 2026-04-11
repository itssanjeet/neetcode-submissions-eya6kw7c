class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        int l1 = nums1.length, l2 = nums2.length;
        int i1 = 0, i2 = 0;
        while(i1 < l1 && i2 < l2){
            if(nums1[i1] < nums2[i2]){
                list.add(nums1[i1++]);
            } else {
                list.add(nums2[i2++]);
            }
        }
        
        while(i1 < l1){
            list.add(nums1[i1++]);
        }

        while(i2 < l2){
            list.add(nums2[i2++]);
        }

        int size = list.size();

        if(size % 2 == 1){
            return (double)list.get(size/2);
        } else {
            int mid = size/2;
            return (list.get(mid) + list.get(mid-1))/2.0;
        }
    }
}
