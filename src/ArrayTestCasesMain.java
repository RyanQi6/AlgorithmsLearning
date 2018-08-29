import java.util.*;
public class ArrayTestCasesMain{
  public void print2DMatrix(int[][] m){
        if(m == null || m.length == 0 || m[0].length == 0){
            return;
        }
        for(int i = 0; i < m.length; i++){
            String s = "";
            for(int j = 0; j < m[0].length; j++){
                s += m[i][j];
                s += ", ";
            }
            System.out.println(s);
        }
    }
    public void print2DMatrix(boolean[][] m){
        if(m == null || m.length == 0 || m[0].length == 0){
            return;
        }
        for(int i = 0; i < m.length; i++){
            String s = "";
            for(int j = 0; j < m[0].length; j++){
                s += m[i][j];
                s += ", ";
            }
            System.out.println(s);
        }
    }
    public void print2DMatrix(char[][] m){
        if(m == null || m.length == 0 || m[0].length == 0){
            return;
        }
        for(int i = 0; i < m.length; i++){
            String s = "";
            for(int j = 0; j < m[0].length; j++){
                s += m[i][j];
                s += ", ";
            }
            System.out.println(s);
        }
    }
    public void print2DMatrix(Object[][] m) {
      if (m == null || m.length == 0 || m[0].length == 0) {
          return;
      }
      for (int i = 0; i < m.length; i++) {
          String s = "";
          for (int j = 0; j < m[0].length; j++) {
              s += m[i][j];
              s += ", ";
          }
          System.out.println(s);
      }
  }
  public void print1DArray(int[] array){
      String s = "";
      for(int i = 0; i < array.length; i++){
          s += array[i];
          s += ",";
      }
      System.out.println(s);
  }
  public static void main(String[] args){
//    int[] nums = {10,9,8,7,99,5,4,3,2,1};
//    int k = 7;
//    new QuickSelect().quickSelect(nums, k, 0, nums.length - 1);
//    int[] array = Arrays.copyOf(nums, k);
//    for(int ele : array)
//      System.out.println(ele);
//    int[][] matrix = {{1,3,5,7},{2,4,8,9},{3,5,11,15},{6,8,13,18}};
//    int result = new KthSmallestInMatrix().kthSmallestInMatrix(matrix, 1);
//    System.out.println(result);

////    Test Case for TopKWords
//    String[] test = {"hello", "hi", "hello", "tony"};
//    String[] result = new TopkWords().topKFrequent(test, 4);
//    for(String s : result){
//      System.out.println(s);
//    }
////    Test Case for RemoveSpaces
//    String s = "   abc  ed ef  ";
//    String result = new RemoveSpaces().removeSpaces(s);
//    System.out.println(result);
////    Test Case for Deduplication
//      String s = "ABBC";
//      System.out.println(new Deduplication().deDup(s));

//      //    Test Case for DictionaryI
//      String s = "defabcdef";
//      String[] set = {"abc","ab","cd","de","def"};
//      System.out.println(new DictionaryI().canBreak(s, set));
//        //  Test Case for EditDistanceI
//      String one = "abcabc";
//      String two = "dabacd";
//      System.out.println(new EditDistance().editDistanceDP(one, two));
//      //  Test Case for Largest Ones I
//      int[][] test = { {0, 0, 0, 0},
//                       {1, 1, 1, 1},
//                       {0, 1, 1, 1},
//                       {1, 0, 1, 1}} ;
////      int[][] test = { {1, 0, 1},
////                    {0, 1, 0},
////                    {1, 0, 1}};
//      System.out.println(new LargestX().largest(test));
////        Test Case for Largest Submatrix Sum
//      int[][] test = { {1, -2, -1, 4},
//
//              {1, -1,  1, 1},
//
//              {0, -1, -1, 1},
//
//              {0,  0,  1, 1} };
//      System.out.println(new LargestSubmatrixSum().largest(test));
////        Test Case for Perfect Shuffle
//      int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//      new PerfectShuffle().shuffle(test);
//      new ArrayTestCasesMain().print1DArray(test);
////        Test Case for Random7 using Random5
//        System.out.println(new Random7UsingRandom5().random7());
            //  Test Case for Largest Ones I
//      int[][] test = { {1,  2,  3, 4},
//
//              {12, 13, 14,  5},
//
//              {11, 16, 15, 6},
//              {10, 9, 8, 7} };
//
//      new RotateMatrix().rotate(test);
//      new ArrayTestCasesMain().print2DMatrix(test);
//        //  Test case for Array Deduplication IV
//      int[] test = {1,2,3,3,2};
//      new ArrayTestCasesMain().print1DArray(new ArrayDeduplicationIV().dedup(test));
//        //  Test case for Array Deduplication IV
//      int[] a = {1,2,3,3};
//      int[] b = {2,3,4,4,5};
//      int[] c = {1,1,3,3};
//      List<Integer> result = new CommonElementsIn3SortedArray().common(a,b,c);
//      System.out.println(result);
//        //Test case for LargestProductOfLength
//      String[] dict = {"aa","bb","ccc","abcfgh","ehi"};
//      int result = new LargestProductOfLength().largestProduct(dict);
//      System.out.println(result);
//      //Test case for KthSmallestWith357
//      long result = new KthSmallestWith357().kth(40);
//      System.out.println(result);

//      //Test case for KthClosestToOrigin
//      int[] a = {1,2,3};
//      int[] b = {2,4};
//      int[] c = {1,2};
//      List<Integer> co = new KthClosestToOrigin().closest(a, b, c, 10);
//      System.out.println(co);
//      new KthClosestToOrigin().eq();
//      //Test case for 2sumAllPairs
//      int[] a = {3,9,1,2,3};
//      int t = 4;
//      List<List<Integer>> r = new TwoSumInAllPairsI().allPairs(a, t);
//      for(List<Integer> l : r) {
//          System.out.println("||");
//          for(Integer i: l)
//            System.out.println(i + ",");
//      }
//      //Test case for 4sum
//      int[] a = {3,1,6,2,5,9,4};
//      int t = 4;
//      System.out.println(new FourSum().exist(a, 9));
//      //Test case for K way merge
//      int[][] a = new int[][]{{1,10},{2,4,8},{3},{6,7,9}};
//      int[] r = new MergeKSortedArray().merge(a);
//      new ArrayTestCasesMain().print1DArray(r);
//      //Test case for Maximum Values Of Size K Sliding Windows
//      int[] a = {5,2,1,4,3,6,2,8,3,1,4};
//      List<Integer> r = new MaxOfSlidingWind().maxWindows(a, 4);
//      for(Integer i: r){
//          System.out.println(i);
//      }
      //Test case for Print all if blocks
//      new PrintAllIfBlocks().printAll(3);
//        StringBuilder sb = new StringBuilder();
//        sb.append("{ ");
//        sb.delete(sb.length() - 2, sb.length());
//        System.out.println(sb.length());
//      //Test case for Print all if blocks
//      new PermutationOfBraceBracketParenthesis().printAll(1);
      //Test case for spiral matrix III
//      new SpiralMatrixIII().spiralMatrixIII(1,4,0,0);
      //Test case for bipartition
//      int[][] a = {{1,3},{2,3},{2,4}};
//      boolean r = new PossibleBipartite().possibleBipartition(4, a);
//      System.out.println(r);
      //Test case for bipartition
        int[] t = {1,1,3,3,1,2,2,4,4,5,6,7,8,9,10};
        System.out.println(new MajorityII().majority(t, 6));
  }
}
