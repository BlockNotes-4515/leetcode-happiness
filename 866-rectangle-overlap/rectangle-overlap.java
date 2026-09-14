class Solution {
    public boolean isRectangleOverlap(int[] rect1, int[] rect2) {
        
        int left=Math.max(rect1[0],rect2[0]);
        int right=Math.min(rect1[2],rect2[2]);

        int bottom=Math.max(rect1[1],rect2[1]);
        int top=Math.min(rect1[3],rect2[3]);

        return left<right && bottom<top;
    }
}