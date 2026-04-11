class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        List<Integer> list = new ArrayList<>();

        int i = 0, j = 0, l1 = nums1.length, l2 = nums2.length;

        while(i < l1 && j<l2){
            if(nums1[i] < nums2[j]){
                list.add(nums1[i++]);
            } else {
                list.add(nums2[j++]);
            }
        }

        while(i < l1){
            list.add(nums1[i++]);
        }

        while(j < l2){
            list.add(nums2[j++]);
        }
        
        int size = list.size();
        int mid = size/2;
        if(size % 2 == 1){
            return (double)list.get(mid);
        }

        return (list.get(mid) + list.get(mid - 1))/2.0;
    }
}
