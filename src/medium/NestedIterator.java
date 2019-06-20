package medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * NestedIterator
 *
 * @author black
 * @date 2019/6/19
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        addData(list, nestedList);
        iterator = list.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    private void addData(List<Integer> list, List<NestedInteger> nestedList) {
        if (nestedList != null) {
            for (NestedInteger data : nestedList) {
                if (data.isInteger()) {
                    list.add(data.getInteger());
                } else {
                    addData(list, data.getList());
                }
            }
        }
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
