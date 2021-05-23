
//comes from CodeSignal: https://app.codesignal.com/interview-practice/task/gX7NXPBrYThXZuanm/description
public class RemoveKFromList {
    // Singly-linked lists are already defined with this interface:
    // class ListNode<T> {
    //   ListNode(T x) {
    //     value = x;
    //   }
    //   T value;
    //   ListNode<T> next;
    // }
    //
    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        if(l == null){
            return l;
        }else if(l.value == k && l.next == null){
            l = null;
            return l;
        }
        ListNode<Integer> curNode = l;
        ListNode<Integer> removedList = new ListNode<Integer>(0); //will remove later!
        while(curNode != null){
            // System.out.println("curNode.value: "+curNode.value);
            System.out.println("curNode.value ("+curNode.value+") == k ?: "+(curNode.value == k));
            if(curNode.value == k){
                curNode = curNode.next;
            }else{
                ListNode<Integer> newNode = new ListNode<Integer>(curNode.value);
                removedList.next = newNode;
                curNode = curNode.next;
                System.out.println("removedList.next.value: "+removedList.next.value);

            }
            // System.out.println("(after update) curNode.value: "+curNode.value);
        }
        //just modify l! don't make a new linkedlist.
        // if(curNode == k){
        //     l = l.next
        //     // curNode
        // }

        return removedList;

    }


}
