// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We Make use of previous variable to save the value
// We also make use of a boolean variable to implement hasnext()
// We make the iterator to be one ahead

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Integer prev;
    boolean valid;
    Iterator<Integer> it;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        valid = it.hasNext();
        prev = it.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return prev;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = prev;
        valid = it.hasNext();
        if (valid)
            prev = it.next();
        else
            prev = null;
        return temp;

    }

    @Override
    public boolean hasNext() {
        return valid;
    }
}