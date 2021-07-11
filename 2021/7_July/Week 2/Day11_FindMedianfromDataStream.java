
//Day 11: 
//Problem Statement: Find Median from Data Stream

// The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

// For example, for arr = [2,3,4], the median is 3.
// For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
// Implement the MedianFinder class:

// MedianFinder() initializes the MedianFinder object.
// void addNum(int num) adds the integer num from the data stream to the data structure.
// double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

// Example 1:

// Input
// ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
// [[], [1], [2], [], [3], []]
// Output
// [null, null, null, 1.5, null, 2.0]

// Explanation
// MedianFinder medianFinder = new MedianFinder();
// medianFinder.addNum(1);    // arr = [1]
// medianFinder.addNum(2);    // arr = [1, 2]
// medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
// medianFinder.addNum(3);    // arr[1, 2, 3]
// medianFinder.findMedian(); // return 2.0
 

// Constraints:

// -105 <= num <= 105
// There will be at least one element in the data structure before calling findMedian.
// At most 5 * 104 calls will be made to addNum and findMedian.
 

// Follow up:

// If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
// If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?

//Solution:
class MedianFinder {
    List<Integer> arr;

    /** initialize your data structure here. */
    public MedianFinder() {
        arr=new ArrayList<>();
    }
    
    private int binarySearch(int k) {
        int l=0, r=arr.size()-1;
        while(l<=r) {
            int mid=l+(r-l)/2;
            if(arr.get(mid)==k)
                return mid;
            else if(arr.get(mid)<k)
                l=mid+1;
            else
                r=mid-1;
        }
        return l;
    }
    
    public void addNum(int num) {
        int idx=binarySearch(num);
        arr.add(idx, num);
    }
    
    public double findMedian() {
        if(arr.size()%2!=0) {
            return arr.get(arr.size()/2);
        } else {
            int l=arr.get(arr.size()/2-1);
            int r=arr.get(arr.size()/2);
            return (l+r)/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//Complexity: O(log*n)

