
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
        //new var = l;
        //look at the head.
        //if it's k, make next node the head until not k.
        //if not, nothing.
        //iterate through l (until new pointer's value is null)
        //is next node == k? if so, change pointer to next next node.
        //if next node != k, then l = l.next;
        //return var;
        while(l != null && l.value == k){
            l = l.next;
        }
        ListNode<Integer> newList = l;
        while(l != null){
            if(l.next != null && l.next.value == k){
                l.next = l.next.next;
            }else{
                l = l.next;
            }
        }
        return newList;

    }


}
