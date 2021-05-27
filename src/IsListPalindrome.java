//comes from CodeSignal: https://app.codesignal.com/interview-practice/task/HmNvEkfFShPhREMn4/description

// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//

//------------------------------------------------- transforming to an ArrayList
boolean isArrListPalindrome(ArrayList<Long> arr){
    int halfwayMark = arr.size() % 2 == 0 ? (arr.size()/2) : (arr.size()/2)-1;
    int idx = 0;
    while(idx < halfwayMark){
        if(!Objects.equals(arr.get(halfwayMark-1-idx), arr.get(halfwayMark+idx))){
            return false;
        }else{
            idx++;
        }
    }
    return true;
}

boolean isListPalindrome(ListNode<Integer> l) {
    //iterate through l to make an arrayList version
    //make and use a new method to test if arrayList is Palindrome
    //whether arrayList is odd or even length, calculate how far in you need to look with rounding down dision.
    //iterate through arrayList and compare two oppositely placed elements. Start inward and move outwards
    //if the two elements are ever not the same, return false.
    //if the loop ends (all are the same), return true.
    ArrayList<Long> lArr = new ArrayList<>();
    while(l!=null){
        lArr.add((long)l.value);
        l = l.next;
    }
    return isArrListPalindrome(lArr);
}