public class mergeTwoLinkedLists {
}
    // Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
// import Collections
// import java.util.LinkedList
    ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ArrayList<Integer> allValues = new ArrayList<Integer>();



        ListNode<Integer> curNode1 = l1;
        ListNode<Integer> curNode2 = l2;
        if(curNode1 == null && curNode2 == null){
            return curNode1;
        }

        while(curNode1 != null){
            allValues.add(curNode1.value);
            curNode1 = curNode1.next;
        }

        while(curNode2 != null){
            allValues.add(curNode2.value);
            curNode2 = curNode2.next;
        }

        Collections.sort(allValues);
        // ListNode<Integer> l3 = new ListNode<Integer>(1);
        // ListNode<Integer> curNode3 = l3;
        // for(Integer num : allValues){
        //     curNode3.value = num;
        //     curNode3 = curNode3.next;
        // }
        // System.out.println(allValues);
        // int indexOfFirstNum = allValues.get(0);
        System.out.println(allValues);
        System.out.println(allValues.size());
        ListNode<Integer> l3 = new ListNode<Integer>(allValues.get(0));
        // ListNode<Integer> curNode3 = l3;
        // curNode3 = curNode3.next;
        // for(int i = 1; i < allValues.size(); i++){
        //     // curNode3.value = allValues.get(i);
        //     // curNode3.value = 0;
        //     // curNode3 = curNode3.next;
        //     // System.out.println("i: "+i);
        // }
        // System.out.println("l3 first value: "+l3.value);
        return l3; //appease computer
    }

