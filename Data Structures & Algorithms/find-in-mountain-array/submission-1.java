/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();

        int peak = findPeak(mountainArr, len);
        
        //Search in Left Portion
        int l = 0;
        int r = peak-1;
        while(l<=r){
            int m = l + (r-l)/2;
            int mid = mountainArr.get(m);
            if(mid == target){
                return m;
            } else if(mid < target){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        l = peak; 
        r = len-1;
        while(l <= r){
            int m = l + (r-l)/2;
            int mid = mountainArr.get(m);
            if(mid == target){
                return m;
            } else if(mid < target){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }

    private int findPeak(MountainArray mountainArr, int len){
        int l = 0;
        int r = len - 1;

        while(l <= r){
            int m = l + (r-l)/2;

            if(m > 0 && m < len+1){
                int lower = mountainArr.get(m-1);
                int mid = mountainArr.get(m);
                int upper = mountainArr.get(m+1);
                if( lower <= mid && mid >= upper){
                    return m;
                } else if(lower < mid && mid < upper){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else if(m == 0){
                int mid = mountainArr.get(m);
                int upper = mountainArr.get(m+1);
                if(mid > upper){
                    return m;
                } else {
                    l = m + 1;
                }
            } else {
                int lower = mountainArr.get(m-1);
                int mid = mountainArr.get(m);
                if(lower < mid){
                    return m;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }
    }