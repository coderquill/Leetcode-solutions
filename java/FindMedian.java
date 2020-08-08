/*https://leetcode.com/problems/find-median-from-data-stream/

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 
*/




class MedianFinder {
   private Queue<Integer> leftSide;
    private Queue<Integer> rightSide;
    
    
    /** initialize your data structure here. */
    public MedianFinder() {
        leftSide = new PriorityQueue<>((a, b) -> {return b - a;});
        rightSide = new PriorityQueue<>((a, b) -> {return a - b;});
    }
    
    public void addNum(int num) {
        leftSide.add(num);
         if (rightSide.size() > 0 && leftSide.peek() > rightSide.peek())
             rightSide.add(leftSide.poll());
        
        if (leftSide.size() > rightSide.size()) rightSide.add(leftSide.poll());
        else if (rightSide.size() > leftSide.size()) leftSide.add(rightSide.poll());
    }
    
    public double findMedian() {
        if ((leftSide.size() + rightSide.size()) % 2 == 0) return (leftSide.peek() + rightSide.peek()) / 2.0;
        if (leftSide.size() > rightSide.size()) return leftSide.peek();
        return rightSide.peek();
    }
}



/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
