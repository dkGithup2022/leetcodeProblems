class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1,nums2);
        //System.out.println(Arrays.toString(merged));
        if(merged.length %2 == 1)
            return merged[merged.length/2];
        
        else
            return  ( (double) merged[merged.length/2] + merged[merged.length/2 -1] ) /2;

    }
    
    int[] merge(int[] nums1 , int[] nums2){
        int[] arr = new int[nums1.length + nums2.length];    
        int p1 = 0;
        int p2 = 0;
        int index =0;
        
        while(p1 != nums1.length  && p2 != nums2.length){
            if( nums1[p1] <= nums2[p2] )
                arr[index++] = nums1[p1++];
            else
                arr[index++] = nums2[p2++];
        }
        
       
         while(p1 != nums1.length)
                arr[index++] = nums1[p1++];
            
         while(p2 != nums2.length)
                arr[index++] = nums2[p2++];
        
        return arr;
    }
}