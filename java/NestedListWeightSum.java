/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.
Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
*/

public int depthSum(List<NestedInteger> nestedList) {
    int sum=0;
 
    LinkedList<NestedInteger> queue = new LinkedList<NestedInteger>();
    LinkedList<Integer> depth = new LinkedList<Integer>();
 
    for(NestedInteger ni: nestedList){
        queue.offer(ni);
        depth.offer(1);
    }
 
    while(!queue.isEmpty()){
        NestedInteger top = queue.poll();
        int dep = depth.poll();
 
        if(top.isInteger()){
            sum += dep*top.getInteger();
        }else{
            for(NestedInteger ni: top.getList()){
                queue.offer(ni);
                depth.offer(dep+1);
            }
        }
    }
 
    return sum;
}
