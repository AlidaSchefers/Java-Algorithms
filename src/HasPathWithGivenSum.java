public class HasPathWithGivenSum {
}
// Binary trees are already defined with this interface:
//class Tree<T> {
//    Tree(T x) {
//        value = x;
//    }
//    T value;
//    Tree<T> left;
//    Tree<T> right;
//}
    boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
        if(t == null){ return false; }
        // boolean sumComparePath(Tree<Integer> t){
        //     int path[] = new int[1000];
        //     sumComparePathRecur(t, path, 0);

        // }
        t.sumComparePath();
        return true;
        // boolean sumComparePathRecur(Tree<Integer> t, int path[], int pathLen){

        // }

    }
