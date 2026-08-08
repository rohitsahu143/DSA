class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n =nums2.length;
        int arr[]=new int[m+n];

        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                arr[k]=nums1[i];
                k++;
                i++;
            }else{
                arr[k]=nums2[j];
                k++;
                j++;
            }
        }
        while (i < m) {
            arr[k] = nums1[i];
            i++;
            k++;
        }

        // Remaining elements of nums2
        while (j < n) {
            arr[k] = nums2[j];
            j++;
            k++;
        }

        int size = arr.length;
         if (size % 2 == 1) {
            return arr[size / 2];
        } else {
            int leftMid = arr[size / 2 - 1];
            int rightMid = arr[size / 2];

            return (leftMid + rightMid) / 2.0;
        }
       

    }
}